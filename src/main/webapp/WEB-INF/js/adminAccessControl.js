function checkPermission(login, permission){
    window.location.href = 'chat?command=block&loginInput=' + login +'&permission=' + permission;
}

function checkPermission1(login){

      window.location.href = 'chat?command=block&loginInput=' + login;
}
