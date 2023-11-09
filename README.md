# spring-oauth-client

<div>
  spring-oauth-client depend on <a href="https://gitee.com/shengzhao/spring-oauth-server">spring-oauth-server</a> or <a href="https://gitee.com/mkk/MyOIDC">MyOIDC</a>,
  it is the oauth2 client demo project.
</div>

<strong>注意</strong>  

- 从 1.1 版本开始支持 spring-oauth-server  config分支 (旧版本的spring-oauth-server 测试请使用 1.0 分支)
- 从2.x版本开始支持 OAuth2.1 协议中的各功能  (对应 spring-oauth-server 的 v3.0.0 及以上版本)

<hr/>


项目用Maven管理


## 主要技术与版本号

<ol>
     <li>Java (openjdk 17)</li>
     <li>SpringBoot (3.1.2)</li>
     <li>thymeleaf (3.1.1.RELEASE)</li>
     <li>HttpClient (4.5.14)</li>
     <li>json-lib (2.4)</li>
     <li>logback (1.4.8)</li>
</ol>
前端使用的技术与版本号
<ol>
    <li>Angular-JS (1.1.5)</li>
    <li>Bootstrap (3.3.4)</li>
</ol>
<hr/>

## 在线测试
<strong>
    OAuth服务端项目请访问 <a href="https://gitee.com/shengzhao/spring-oauth-server">spring-oauth-server</a>
</strong>
<br/>
<strong>
    在线测试地址 <a href="https://andaily.com/spring-oauth-client/">https://andaily.com/spring-oauth-client/</a> (v1.x版本)
</strong>

<hr/>

## 如何使用?

前提: 在使用之前必须保证 spring-oauth-server 项目已正常运行.
<ol>
    <li>
        项目是Maven管理的, 需要本地安装maven(开发用的maven版本号为3.6.0)
    </li>
    <li>
        <a href="https://gitee.com/mkk/spring-oauth-client">下载</a>(或clone)项目到本地
    </li>
    <li>
        修改<code>application.properties</code>(位于src/main/resources目录)中的配置信息(主要包括与spring-oauth-server的连接地址)
    </li>
    <li>
        将本地项目导入到IDE(如Intellij IDEA)中, 直接运行启动类 <mark>SpringOAuthClientApplication.java</mark>, 通过浏览器访问即可(默认端口 8082).
        <br/>
        所有的操作说明都在页面上体现.
        <br/>
           另: 也可通过maven package命令将项目编译为jar文件(spring-oauth-client.jar), 然后通过java -jar命令运行.
    </li>
    <li>
        <p>
            若在<strong>Android</strong>或移动设备中使用, 可查看示例代码 <code>AndroidClientTest.java</code>(位于<em> src/master/src /test /java /com/andaily/springoauth/client/</em>目录).
            里面包括获取 access_token 与 调用API的示例.
        </p>
    </li>
</ol>


<hr/>

## 实现思路

<p>
    spring-oauth-client 的实现没有使用开源项目 <a
        href="https://github.com/spring-projects/spring-security-oauth/tree/master/spring-security-oauth2"
        target="_blank">spring-security-oauth2</a> 中提供的代码与配置, 如:<code>&lt;oauth:client
    id="oauth2ClientFilter" /&gt;</code>
</p>
<div>
    而是按照OAuth2协议支持的各类grant_type依次去实现.
    <br/>
    详见博客 <a href="https://andaily.com/blog/?p=103" target="_blank">https://andaily.com/blog/?p=103</a>

</div>


<p>
    项目的开发管理使用开源项目 <a href="https://gitee.com/mkk/andaily-developer">andaily-developer</a>.
</p>
<hr/>

## 项目日志

<ol>
    <li>
        <p>2015-03-17    项目创建</p>
    </li>
    <li>
        <p>2015-06-02    V-0.1版本发布</p>
    </li>
    <li>
        <p>2015-11-16    添加在线测试, 访问地址 http://andaily.com/spring-oauth-client/ </p>
    </li>
    <li>
        <p>2018-04-16    V-1.0发布; 开始V-1.1,增加对OIDC协议支持 </p>
    </li>   
    <li>
        <p>2023-11-04    v2.0.0准备开发, 升级支持spring-oauth-server中 OAuth2.1与OIDC 1.0 协议 </p>
    </li>    
    <li>
        <p>2023-11-09    v2.0.0发布 </p>
    </li>
</ol>


<hr/>

## 参考资源

以下是在开发与学习过程中参考的Oauth资源,总结下来方便学习回顾.
<ul>
    <li><p>
        <a href="http://www.dannysite.com/blog/176/">OAuth2：Authorization Flows</a>
    </p></li>
    <li><del>
        <a href="http://www.dannysite.com/blog/178/">OAuth2：隐式授权（Implicit Grant）类型的开放授权</a>
    </del> <code>OAuth2.1中不再支持</code></li>
    <li><p>
        <a href="http://www.tuicool.com/articles/QrUVvuf">oauth2.0协议之Implicit grant模式解析</a>
    </p></li>
</ul>


<hr/>

## 周边相关

<div>
    与项目相关的技术文章请访问 <a href="https://andaily.com/blog/?cat=19">https://andaily.com/blog/?cat=19</a> (不断更新与OAuth/OIDC相关的文章)
</div>
<p>
    <strong>问答与讨论</strong>
    <br/>
    与项目相关的，与OAuth相关的问题与回答，以及各类讨论请访问<br/>
    <a href="https://andaily.com/blog/?dwqa-question_category=oauth">https://andaily.com/blog/?dwqa-question_category=oauth</a> 或提 issue
</p>

<br/>
<p>
 关注更多我的开源项目请访问 <a href="https://andaily.com/my_projects.html">https://andaily.com/my_projects.html</a>
</p>
<p>
 若需更多的技术支持请联系 <a href="mailto:monkeyk@shengzhaoli.com">monkeyk@shengzhaoli.com</a>
</p>

<hr/>
<div>
  Expect your joining...
</div>