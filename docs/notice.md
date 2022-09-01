|       类别        |                             规范                              |  等级  |
|:---------------:|:-----------------------------------------------------------:|:----:|
|      统一语言       |                      与统一语言（英文）一致的代码命名                       |  强制  |
|     domain层     |              Domain仅包含领域模型定义的对象。且用plain object              |  强制  |
|                 |                Domain层不依赖spring的AOP和IOC等三方包                 |  推荐  |
|                 |           Domain对象拒绝Getter、Setter、Constructor等注解            |  强制  |
|                 |   Domain对象行为拒绝setter、update、modify、save、delete等无明确业务含义的方法   |  强制  |
|                 |                    值对象命名不用加上标识技术语言的Enum                     |  强制  |
|  application层   | application层拒绝xxxHandler、xxxProcessor 、 xxxContext等含义不明确的命名 |  强制  |
|                 |      区分命令和查询，命令推荐xxxCommandservice，查询推荐xxxQueryService      |  推荐  |
| infrastructure层 |              Repository的入参和出参除了原始数据类型，只能包含领域对象              |  强制  |
|                 |                 对外接口访问的防腐层，統一命名为xxxAdaptor                  |  建议  |
|                 |                        禁止外部接口对象向上层透传                        |  强制  |
|       事件        |                  事件命名为事件+Event，且事件命名为动词过去时                  |  强制  |