<%--
 * 
 * @author Shengzhao Li
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>authorization_code</title>
</head>
<body>
<a href="${contextPath}/">Home</a>

<h2>authorization_code</h2>

<form action="authorization_code" method="post">
    <p>
        <label>
            AuthorizationUri: <input type="text" name="userAuthorizationUri" value="${userAuthorizationUri}"
                                     size="50" required="required"/>
        </label>
    </p>

    <p>
        <label>
            response_type(Fixed): <input type="text" name="responseType" value="code" readonly="readonly"/>
        </label>
    </p>

    <p>
        <label>
            scope: <select name="scope">
            <option value="read">read</option>
            <option value="write">write</option>
            <option value="read,write">read,write</option>
        </select>
        </label>
    </p>

    <p>
        <label>
            client_id: <input type="text" name="clientId" value="unity-client" required="required"/>
        </label>
    </p>

    <p>
        <label>
            redirect_uri: <input type="text" name="redirectUri" value="${host}authorization_code_callback"
                                 required="required" size="50"/>
        </label>
    </p>

    <p>
        <label>
            state(optional): <input type="text" name="state" value="${state}" size="50"/> -- A random value
        </label>
    </p>


    <br/>

    <div style="border:1px solid #eee;">
        Final send to 'Oauth Server' URL: <strong>${userAuthorizationUri}</strong>
    </div>
    <br/>
    <button type="submit">Submit</button>
</form>
</body>
</html>