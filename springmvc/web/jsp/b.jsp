<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <meta charset="UTF-8">
    <title>Fluid Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyui/demo.css">
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
  <body>
    <%=request.getAttribute("idq")%>
    <div class="easyui-panel" title="New Topic" style="width:400px">
        <div style="padding:10px 60px 20px 60px">
            <form id="ff" method="post" enctype="multipart/form-data">
                <table cellpadding="5">
                    <tr>
                        <td>Name:</td>
                        <td><input class="easyui-validatebox" type="text" id="name" name="name" data-options="required:true,missingMessage:'请输入姓名'" /></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input class="easyui-validatebox" type="text" id="email" name="email" data-options="validType:'email',invalidMessage:'请输入正确格式的EMail'" /></td>
                    </tr>
                    <tr>
                        <td>Time:</td>
                        <td><input id="dt" class="easyui-datetimebox" name="birthday"
                                   data-options="required:true,showSeconds:true,missingMessage:'请选择时间'" style="width:150px">
                        </td>
                    </tr>
                    <tr>
                        <td>file:</td>
                        <td><input class="easyui-filebox" name="file2" data-options="prompt:'Choose another file...'" style="width:100%">
                            <input class="easyui-bu">
                        </td>
                    </tr>
                </table>
            </form>
            <div style="text-align:center;padding:5px">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
            </div>
        </div>
    </div>
    <script>
        function submitForm(){
            var v = $('#dt').datetimebox('getValue');		         // 获取日期时间输入框的值
            alert(v);
            $.post("<%=request.getContextPath()%>/multy.do",
                {
                    action:"test",
                    name:$('#name').val(),
                    email:$('#email').val(),
                    datetime:$("#dt").datetimebox('getValue')
                },
                function(data,status){
                    alert("Data: " + data + "\nStatus: " + status);
                });
//            $('#ff').form('submit');
        }
        function clearForm(){
            $('#ff').form('clear');
        }
    </script>
  </body>
</html>
