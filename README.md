                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/'---'\____
             .'  \\|     |//  '.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  '-'  ___/-. /
         ___'. .'  /--.--\  '. .' ___
      ."" '<  '.___\_<|>_/___.'  >' "".
     | | :  '- \'.;'\ _ /';.'/ -'  : | |
     \  \ '-.   \_ __\ /__ _/   .-' /  /
     ===================================
            佛祖保佑       永无BUG


# ！！请把每次commit内容书写在本文档！！
# commit内容
## 6.30
* 用户的删除 
* goods的问题修正 没有import lombok.Data;
* 二次确认是否删除
* 数据库使用sha加密
> 手动加密密码方法：
> 1. 找utils包里的EncryptUtil类
> 2. 找到main函数，将str赋值为你的密码
> 3. 运行此类的main函数
> 4. 将控制台输出的加密后的复制粘贴到数据库中
  
自动化方法开发中

## 7.1
* 订单管理完成 hj
* 货物新增功能完成 hxy
* 用户添加完成 ymm
* 货物管理完成 hxy
* 订单类型 zls
* 订单创建时间和订单结束时间 zls
* 实现修改功能；解决了界面输入中文乱码的问题 hxy 16:32
* 订单操作员和订单创建人 下拉框 zls
* user界面新增用户的密码加密 hj
* Login界面添加验证码功能 wlx
* users 删除debug hj
* 注意mapping的地址和axios 的URL "http://localhost:8080/users/" + userId 对应为 "http://localhost:8080/users/{id}
* 完成新建订单（时间选择，订单类型选择）hj
* 简陋的页面跳转 
  仓库页面的建立（复制的货品页面 只改了文本部分）zls
* 用户界面的增删改实现 ymm


## 7.2
* 实现使用iframe嵌入网页进行跳转 hxy 10:29
* 更改仓库名 新建market页面 zls
* 超市货物员页面 剩余页面iframe更新 多余注释代码删除 zls 
* 登录界面完善（还有一个小小的BUG）WLX
* 所有查询按钮 所有页面中的增加和编辑方法 所有按钮的icon zls
* 操作员页面 ymm 注意前端prop里的内容一定要和实体类中的名字一致！
* 添加uesrInfo表及相关类，添加userDetail类，连结user类和userInfo类到userDetail
* idGenerator跟据userInfo 的 alter time 和 userid产生 userDetail id hj
* 修改了删除只能删最后一个的bug hxy 17:30
* 更正删除功能 hxy 修改所有编辑删除 zls

## 7.4
* 添加吉祥物 hj
* StockIn StockOut 的save功能 hj
* good->goods 部分查询代码 zls
* number删掉 zls
* 订单自动生成 hj
* stock-in-apply.html 实现前端 ymm
* 完成货物员的入库申请 ymm
* 修正goods页面的问题 zls
* goods模糊查询bug zls
* Stockin 完成 hj
* 完成入库申请订单号前端对接 ymm
> > 一点提示： 前端调用接口的时候一定要注意大小写、单复数，名字不要写错
* stockOut 完成 StockIn 和 StockOut 优化整合 hj

## 7.5
* 提示出入库数量不能为零 ymm
* goods名称的模糊查询 zls
* 用户详情编辑完成；用户详情显示存在bug hxy
* Detail debug order添加update hj
