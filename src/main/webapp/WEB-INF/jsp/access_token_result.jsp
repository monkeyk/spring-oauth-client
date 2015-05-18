<%--
 * 
 * @author Shengzhao Li
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Token</title>
</head>
<body>
<a href="${contextPath}/">Home</a>

<h2>Access Token is OK</h2>

<dl class="dl-horizontal">
    <dt>access_token</dt>
    <dd><code>${accessTokenDto.access_token}</code></dd>
    <dt>token_type</dt>
    <dd><code>${accessTokenDto.token_type}</code></dd>
    <dt>refresh_token</dt>
    <dd><code>${accessTokenDto.refresh_token}</code></dd>
    <dt>scope</dt>
    <dd><code>${accessTokenDto.scope}</code></dd>
</dl>
<p>
    Now you can visit the resources as follow:
</p>
<ul>
    <li><a href="${contextPath}/unity_user_info?access_token=${accessTokenDto.access_token}">Oauth Server User
        Information</a></li>
    <li>...</li>
    <li>...</li>
</ul>

</body>
</html>