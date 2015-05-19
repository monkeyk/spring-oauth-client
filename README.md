#spring-oauth-client

<div>
  spring-oauth-client depend on <a href="http://git.oschina.net/shengzhao/spring-oauth-server">spring-oauth-server</a>,
  it is the oauth2 client demos.
</div>

<hr/>


项目用Maven管理


使用的技术与版本号
<ol>
     <li>JDK (1.7.0_40)</li>
     <li>Spring (3.1.1.RELEASE)</li>
     <li>Spring Security (3.1.0.RELEASE)</li>
     <li>HttpClient (4.3.5)</li>
     <li>json-lib (2.4)</li>
     <li>Log4j (1.2.14)</li>
</ol>
前端使用的技术与版本号
<ol>
    <li>Angular-JS (1.1.5)</li>
    <li>Bootstrap (3.3.4)</li>
</ol>
<hr/>

<p>
    服务端项目请访问 <a href="http://git.oschina.net/shengzhao/spring-oauth-server">spring-oauth-server</a>
</p>


<p>
    <strong>如何使用?</strong>
    <br/>
    前提: 在使用之前必须保证 spring-oauth-server 项目已正常运行.
    <ol>
        <li>
            项目是Maven管理的, 需要本地安装maven(开发用的maven版本号为3.1.0)
        </li>
        <li>
            <a href="http://git.oschina.net/mkk/spring-oauth-client/repository/archive?ref=master">下载</a>(或clone)项目到本地
        </li>
        <li>
            修改<code>spring-oauth-client.properties</code>(位于src/main/resources目录)中的配置信息(主要包括与spring-oauth-server的连接地址)
        </li>
        <li>
            将本地项目导入到IDE(如Intellij IDEA)中,配置Tomcat(或类似的servlet运行服务器), 并启动Tomcat(默认端口为8080) ,通过浏览器访问即可.
            <br/>
            所有的操作说明都在页面上体现.
            <br/>
               另: 也可通过maven package命令将项目编译为war文件(spring-oauth-client.war),
                     将war放在Tomcat中并启动(注意: 这种方式需要将spring-oauth-client.properties加入到classpath中并正确配置)
        </li>
    </ol>
</p>



<hr/>
<div>
  Expect your joining...
</div>