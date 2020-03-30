1、有模板引擎的情况下：springboot会去静态资源目录下 的 error/状态码.html;【将错误页面命名为错误代码.html放在模板引擎文件夹里面的error文件夹下】，发生此状态码的错误就会来到对应的页面；
我们可以使用4xx,5xx作文错误页面文件名来匹配这种类型的所有错误，当前精确优先(优先寻找精确的错误码.html)
错误页面上可以获取如下信息：（springboot的错误处理组件想页面写了这些信息）
<h1>status:[[${status}]]</h1>
<h2>timestamp:[[${timestamp}]]</h2>
<h2>exception:[[${exception}]]</h2>
<h2>message:[[${message}]]</h2>
<h2>ext:[[${ext.code}]]</h2>
<h2>ext:[[${ext.message}]]</h2>

2、如果模板引擎下找不到相应的error页面，但静态资源目录下有，这也是可以显示相应页面的
3、以上都没有则只能显示空白错误页面了