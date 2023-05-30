<p align="center">
  <a href="https://github.com/began-zhao/kafeiMal" target="_blank"><img src="https://mmbiz.qpic.cn/mmbiz_png/SC4afG0WMuXc68hWaEeHZBaPWFHhwucI8hdhzciafRFCGjXKricVtkahIxV21VOfzYsAypefMbiaZPBxfdJB16hLw/640?wx_fmt=png"></a>
</p>
<p align="center">
    <a href="https://github.com/began-zhao/studydraw#%E7%9B%AE%E5%BD%95"><img src="https://img.shields.io/badge/WeChat-%E7%A8%8B%E5%BA%8F%E7%8C%B4%E5%92%96%E9%A3%9E-blue"></a>
    <a href="https://github.com/began-zhao/studydraw#%E7%9B%AE%E5%BD%95"><img src="https://img.shields.io/badge/csdn-CSDN-orange"></a>
    <a href="https://github.com/began-zhao/studydraw#%E7%9B%AE%E5%BD%95"><img src="https://img.shields.io/badge/cnblogs-%E5%8D%9A%E5%AE%A2%E5%9B%AD-9cf"></a>
    <a href="https://github.com/began-zhao/studydraw#%E7%9B%AE%E5%BD%95"><img src="https://img.shields.io/badge/oschina-%E5%BC%80%E6%BA%90%E4%B8%AD%E5%9B%BD-brightgreen"></a>
</p>

##

该项目是针对自己理解使用 DDD 落地构建微服务解决方案的参考项目。

## 前言

### 什么是DDD（Domain Driven Design  领域驱动设计 ）

ABP框架提供了**基础设施**使基于**领域驱动设计**的开发更易实现. DDD在[维基百科中的定义](https://zh.wikipedia.org/wiki/%E5%9F%9F%E9%A9%B1%E5%8A%A8%E5%BC%80%E5%8F%91)如下:

> 领域驱动设计(DDD) 是一种通过将实现连接到持续进化的模型来满足复杂需求的软件开发方法. 领域驱动设计的前提是:
>
> - 把项目的主要重点放在核心领域和领域逻辑上
> - 把复杂的设计放在领域模型上
> - 发起技术专家和领域专家之间的创造性协作,以迭代方式完善解决特定领域问题的概念模型

上面是比较官方的解释，概念来源于2004年著名建模专家eric evans发表的他最具影响力的书籍，一句话总结就是：

以**真实世界**及**业务情况**进行详细的**代码建模**(领域)，然后再基于领域模型的变更，指导程序的变更。                                                                                                                      —— 沃·兹基硕德

## 概念

在开始项目介绍前我们先得知道 DDD 只是一种来满足复杂需求的软件开发方法。实现DDD高度依赖面向对象编程思想(OOP)和[SOLID](https://zh.wikipedia.org/wiki/SOLID_(%E9%9D%A2%E5%90%91%E5%AF%B9%E8%B1%A1%E8%AE%BE%E8%AE%A1))原则。事实上，DDD已经**实现**并**延伸**了这些原则，因此，**深入了解**OOP和SOLID对实施DDD十分有利。但是还是有一些具体的概念需要我们来提前熟悉一下

- 领域层
    - 实体：*一个没有从其属性,而是通过连续性和身份的线索来定义的对象*
    - [聚合根](https://martinfowler.com/bliki/DDD_Aggregate.html)：*一组可以作为一个单元处理的域对象.例如,订单及订单系列的商品*
    - 值对象：*一个对象,表示领域的描述方面,没有概念上的身份被称为 值对象。*
    - 仓储：*在领域层和数据映射层之间进行中介,使用类似集合的接口来操作领域对象。*
- 应用层
    - 应用服务：应用服务实现应用程序的**用例**, 将**领域层逻辑公开给表示层。**

可能会有点模糊，具体内容可根据代码理解。

## 项目架构

kaifeiMall 基于DDD的架构分为四个基础层

- **表示层**: *为用户提供接口，使用应用层实现与用户交互。*
- **应用层**: *表示层与领域层的中介，编排业务对象执行特定的应用程序任务。 使用应用程序逻辑实现用例。*
- **领域层**: *包含业务对象以及业务规则。 是应用程序的核心。*
- **基础设施层**: *提供通用的技术功能，支持更高的层，主要使用第三方类库。*

同样；分层架构也可以如下图所示：被称为 **整洁架构** ， 又或者称为 **洋葱架构**

![DDD.png](https://mmbiz.qpic.cn/mmbiz_png/SC4afG0WMuXc68hWaEeHZBaPWFHhwucI8SaMIydS1Viafmlbz1Bmn5Dp6EqI7Jxwdnd89BFicdmwNFrD4S4J66kQ/640?wx_fmt=png)

## 工程模块结构

为了更好的实践 DDD 的特点，选择搭建简单的微服务电商平台来落地。

工程模块如下：

| 工程模块 | 介绍 |
| --- | --- |
| kafeimall-common | 项目公共包：存储着项目公共常量/枚举/Bean |
| kafeimall-gateway | 项目网关：负责具体请求转发/路由 |
| kafeimall-service | 微服务模块：处理真实请求，包含电商具体服务：会员/商品/订单/营销…… |
| kafeimall-service-api | 服务相关的RPC接口层：只有接口和必要的入参依赖 |

DDD 模块拆分如下（以商品服务为例，其他服务一致）：

```html
product        
├─application                --应用服务层：负责操作多个领域服务，完成User Case
│  ├─converter               --DTO与DO的转换
│  ├─dto                     --DTO对象
│  └─impl                    --应用层具体实现内容
├─domain                     --领域服务层：负责操作多个领域对象，实现领域内的业务逻辑
│  ├─eventHandles            --领域事件
│  │  └─model                --领域事件对象
│  ├─model                   --领域对象
│  │  ├─do                   --聚合根\值对象\实体
│  ├─repository              --资源层接口
│  └─service                 --领域服务实现
│      └─impl                --
├─httpapi                    --对外接口层：处理用户界面请求以便于在用户界面展示
│  └─controller              --对外controller
└─infrastructure             --基础设施层：对领域的存储和访问进行统一管理
    ├─cache                  --资源存储的逻辑，例如redis
    ├─config                 --配置项
    │  ├─exception           --异常处理项
    │  └─interceptor         --拦截器
    └─facade                 --防腐层：对外部上下文的访问进行一次转义
```

## 技术栈

| 技术栈 | 实现 |
| --- | --- |
| 开发语言 | Java(JDK11) |
| 项目管理工具 | Gradle 6.9 |
| 集成开发工具 | IDEA 2022 |
| 项目环境 | SpringBoot 2.5.3 |
| 关系型数据库 | MySQL 5.7.x |
| 缓存数据库 | Redis:lastet |
| ORM框架 | SpringData JPA 2.5.6 |
| 配置中心 | Nacos |
| 消息队列 | Kafka & Rabbit & RocketMQ |
| 检索引擎 | Elaticsearch |

## 当前架构

![jiegou.png](https://mmbiz.qpic.cn/mmbiz_png/SC4afG0WMuXc68hWaEeHZBaPWFHhwucI6UZdA9UibLibSyq1P6tHzavMwQ9WlE5T46oatLgQu5ibX1tvB4HlhcIQg/640?wx_fmt=png)

## 里程路线

- [x]  创建全新空白微服务解决方案
- [x]  更改为 Gradle 构建工具
- [x]  将商品部分逻辑实现到服务中
- [x]  整合 Spring Data ElasticSearch
- [x]  整合 Kafka 作为事件总线
- [ ]  补充订单部分逻辑  

## 公众号

关注公众号，交流并学习更多项目经验<br/>
<img src="https://mmbiz.qpic.cn/mmbiz_png/SC4afG0WMuXc68hWaEeHZBaPWFHhwucIVe3sgv7MAOxNIFAfQsxvEBp7w3fgJedxRKzibvoVvjGEztfILJzkf8A/640?wx_fmt=png" width="30%">
