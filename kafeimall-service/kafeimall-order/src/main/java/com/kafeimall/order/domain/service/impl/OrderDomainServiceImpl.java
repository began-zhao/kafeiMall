package com.kafeimall.order.domain.service.impl;

import com.kafeimall.order.domain.service.OrderDomainService;
import org.springframework.stereotype.Service;

/**
 * @author: zzg
 * @date: 10/19/22
 * @Description: 订单领域服务实现
 */
@Service
public class OrderDomainServiceImpl implements OrderDomainService {

//    private ThreadLocal<OrderSubmitRequestAggregate> confirmThreadLocal = new ThreadLocal<>();
//
//    @Resource
//    OrderRepository orderRepository;
//
//    @Resource
//    MemberAdaptor memberAdaptor;
//
//    @Resource
//    CartFeignAdaptor cartFeignAdaptor;
//
//    @Resource
//    WmsFeignAdaptor wmsFeignAdaptor;
//
//    @Autowired
//    ThreadPoolExecutor executor;
//
//    @Autowired
//    RedisService redisUtil;
//
//    @Autowired
//    StringRedisTemplate redisTemplate;
//
//    @Autowired
//    RabbitTemplate rabbitTemplate;
//
//    /**
//     * 根据购物车ID新增订单
//     * @param cartIds 购物车ID选中的集合
//     * @return OrderAggregate 订单聚合根
//     */
//    @Override
//    public OrderConfirmAggregate generateConfirmOrder(List<Long> cartIds) throws ExecutionException, InterruptedException {
//        OrderConfirmAggregate confirm = new OrderConfirmAggregate();
//        UserDto userDto = LoginUserInterceptor.LoginUser.get();
//
//        CompletableFuture<Void> getAddressFuture = CompletableFuture.runAsync(() -> {
//            //1、远程查询所有的收货地址列表
//            List<MemberAddress> address = memberAdaptor.getAddress(userDto.getId());
//            confirm.setAddress(address);
//        }, executor);
//
//
//        CompletableFuture<Void> cartFuture = CompletableFuture.runAsync(() -> {
//            //2、远程查询购物车所有选中的购物项
//            List<CurrentUserCartItems> items = cartFeignAdaptor.getCurrentUserCartItems();
//            confirm.setItems(items);
//        }, executor).thenRunAsync(() -> {
//            List<CurrentUserCartItems> items = confirm.getItems();
//            List<Long> collect = items.stream().map(item -> item.getSkuId()).collect(Collectors.toList());
//            //远程查询库存
//            Map<Long, Boolean> skusHasStock = wmsFeignAdaptor.getSkusHasStock(collect);
//            confirm.setStocks(skusHasStock);
//        }, executor);
//
//        //todo 3、获取用户积分
////        Integer integration = userDto.getIntegration();
////        confirm.setIntegration(integration);
//
//        //4、订单总额\应付价格
//        //自动计算
//
//        //TODO 5、防重令牌
//        String token = UUID.randomUUID().toString().replace("-", "");
//       redisUtil.sAdd(OrderConstant.USER_TOKEN_ORDER_PREFIX + userDto.getId(), token, 30L, TimeUnit.MINUTES);
//        confirm.setOrderToken(token);
//
//        CompletableFuture.allOf(getAddressFuture, cartFuture).get();
//
//        return confirm;
//    }
//
//    /**
//     * 下单
//     * @param orderSubmitRequestAggregate 下单信息
//     * @return 下单成功返回订单具体信息
//     */
//    @Override
//    public SubmitOrderResponseAggregate submitOrder(OrderSubmitRequestAggregate orderSubmitRequestAggregate) {
//
//        confirmThreadLocal.set(orderSubmitRequestAggregate);
//        SubmitOrderResponseAggregate responseVo = new SubmitOrderResponseAggregate();
//        responseVo.setCode(0);
//
//        //1、验证临牌【令牌的对比和删除必须保证原子性】
//        //0-令牌失败 1-令牌成功
//        String script = "if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
//        UserDto userDto = LoginUserInterceptor.LoginUser.get();
//        String orderToken = orderSubmitRequestAggregate.getOrderToken();
//
//        String redisToken = redisTemplate.opsForValue().get(OrderConstant.USER_TOKEN_ORDER_PREFIX + userDto.getId());
//        //使用lua脚本原子验证令牌和删除令牌
//        Long result = redisTemplate.execute(new DefaultRedisScript<Long>(script, Long.class), Arrays.asList(OrderConstant.USER_TOKEN_ORDER_PREFIX + userDto.getId()), orderToken);
//        if (result == 0L) {
//            //令牌验证失败
//            responseVo.setCode(1);
//            return responseVo;
//        } else {
//            //令牌验证成功
//            //下单：去创建订单，验证令牌，验价格，锁库存
//            //1、创建订单，订单项等信息
//            OrderAggregate order = new OrderAggregate();
//
//            //2、验价
//            BigDecimal payAmount = order.getPayAmount();
//            BigDecimal payPrice = orderSubmitRequestAggregate.getPayPrice();
//            if (Math.abs(payAmount.subtract(payPrice).doubleValue()) < 0.01) {
//                //金额对比
//
//                //3、保存订单
//                order.setModifyTime(new Date());
//                orderRepository.insertOrder(order);
//                //4、库存锁定,出现异常，全部回滚
//                //订单号，所有订单项(skuId、skuName、num)
//                WareSkuLock lockVo = new WareSkuLock();
//                lockVo.setOrderSn(order.getOrderSn());
//                List<SubmitOrderItem> orderItemVos = order.getItemEntities().stream().map(item -> {
//                    SubmitOrderItem itemVo = new SubmitOrderItem();
//                    itemVo.setSkuId(item.getSkuId());
//                    itemVo.setCount(item.getSkuQuantity());
//                    itemVo.setTitle(item.getSkuName());
//                    return itemVo;
//                }).collect(Collectors.toList());
//                lockVo.setLocks(orderItemVos);
//                //远程锁定库存
//                //库存成功了。但是网络原因超时，订单回滚，库存不回滚
//                Result r = wmsFeignAdaptor.orderLockStock(lockVo);
//                if (r.getCode() == 0) {
//                    //锁定成功
//                    responseVo.setOrder(order);
//
//                    //TODO 远程扣减积分  模拟异常引出分布式事务
////                    int i = 10 / 0;//订单回滚，库存不回滚
//                    //TODO 订单创建成功发送消息给MQ
//                    rabbitTemplate.convertAndSend("order-event-exchange", "order.create.order", order);
//                    return responseVo;
//                } else {
//                    //TODO 锁定失败
//                    String msg =  r.getMessage();
//                    throw new NoStockException(msg);
////                    responseVo.setCode(3);
////                    return responseVo;
//
//                }
//
//            } else {
//                //验价失败
//                responseVo.setCode(2);
//                return responseVo;
//            }
//        }
//    }
//
//    @Override
//    public void createOrder(OrderAggregate orderAggregate) {
//        orderRepository.insertOrder(orderAggregate);
//    }
//
//    @Override
//    public void updateOrder(OrderAggregate orderAggregate) {
//        orderRepository.updateOrder(orderAggregate);
//    }
//
//    @Override
//    public  OrderAggregate getOrderBuOrderSn(String orderSn){
//        return orderRepository.getByOrderNo(orderSn);
//    };
}
