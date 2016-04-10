#ShellUtil的使用实例之重启管理器

##基本原理还是ShellUtil的使用,详情请看上篇文章
[Android WIFI密码查看器实例(在获取Root权限下查看系统文件)](http://blog.csdn.net/qq_26971803/article/details/50962629)

##本文主要介绍使用Shell调用关机,重启,快速重启,刷机模式,引导模式的方法,直接看代码吧
###首先看一下App的实例(因为功能特殊,不方便演示了,只有主界面
![这里写图片描述](http://img.blog.csdn.net/20160325233333988)
###关机
```
public void ShutDown(View view) {
   ShellUtils.execCommand("reboot -p", true);
}
```
###重启
```
public void Reboot(View view) {
   ShellUtils.execCommand("reboot", true);
}
```
###快速重启
```
public void FastReboot(View view) {
     ShellUtils.execCommand("busybox killall system_server", true);
}
```
###进入刷机模式
```
public void Recovery(View view) {
    ShellUtils.execCommand("reboot recovery", true);
}
```
###进入引导模式
```
public void FastBoot(View view) {
    ShellUtils.execCommand("reboot bootloader", true);
}
```
