function checkPermission(login, permission){
    window.location.href = 'chat?command=block&loginInput=' + login +'&permission=' + permission;
}
