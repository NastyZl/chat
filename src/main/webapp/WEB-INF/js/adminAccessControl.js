function checkPermission1(login, permission) {
    let checkbox = document.getElementsByName("box")[0]
    if (checkbox.checked) {
        window.location.href = 'chat?command=block&loginInput=' + login + '&permission=' + permission;
    } else {
        window.location.href = 'chat?command=block&loginInput=' + login + '&permission=' + permission;
    }
}
