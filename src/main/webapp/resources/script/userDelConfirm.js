function _deleteUser(){

    this.deleteBook = function(id){
        if (confirm("Are you sure?")){
            window.location = "/admin/removeuser/" + id;
        }
    }

}

var deleteUser = new _deleteUser();