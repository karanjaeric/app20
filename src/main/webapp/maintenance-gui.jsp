<html>

<body>
<form action="" method="post">
    <table>
        <tr><td>Maintenance Mode:</td>
            <td><select name="maintenance-mode">
                <option value="0">NORMAL OPERATION</option>
                <option value="1">DOWN FOR MAINTENANCE</option>
            </select></td>
        </tr>
        <tr> <td>Comment:</td>
            <td><textarea name="aComment" rows="5" cols="60">
               We are working on it to make sure that the web portal is back up as soon as possible
                Thank you for your understanding.
          </textarea>
            </td>
        </tr>
        <tr><td>Password: </td>
            <td><input name="password" type="password" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Set Maintenance Mode"/> </td>
        </tr>

    </table>
</form>
</body>
</html>