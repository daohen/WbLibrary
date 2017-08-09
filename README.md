# 针对微博常用的分享和登陆功能进行的二次封装

使用方法

首先在build.gradle中配置如下
```gradle
allprojects {
    repositories {
        jcenter()
        maven { url 'https://jitpack.io' }
        maven { url "https://dl.bintray.com/thelasterstar/maven/" }
    }
}
dependencies {
    compile 'com.github.daohen:personalToolboxLibrary:xx'
    compile 'com.github.daohen:thirdPartyLibrary:xx'
    compile 'com.github.daohen:WbLibrary:xx'
}
```
上面依赖的其它两个libray详情可参照

[personalToolboxLibrary][1]

[thirdPartyLibrary][2]

关于混淆
```
-keep class com.sina.weibo.sdk.** { *; }
```

[1]:https://github.com/daohen/personalToolboxLibrary
[2]:https://github.com/daohen/thirdPartyLibrary