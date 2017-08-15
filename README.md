使用方法
=======

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

关于所需要的so文件，已经放在根目录下的so文件夹下，需要哪些可自行添加，为避免与其它包so产生问题，就没有放到lib里面，需要自己放到主的项目的libs下面

关于混淆
-------
```
-keep class com.sina.weibo.sdk.** { *; }
```

[1]:https://github.com/daohen/personalToolboxLibrary
[2]:https://github.com/daohen/thirdPartyLibrary