/**
 * 
 */
function change(type,node){
	var event = node.parentNode;
	if (type == "TODO")
		type = 'DOING';
	else if (type == "DOING"){
		type = 'DONE';
		item.removeChild(node);
	}
	
	var list = document.querySelector("section[id=" + type + "]");
	list.appendChild(event);
}
function status(id, node){
	 var httpRequest = new XMLHttpRequest();
	 var type = node.parentNode.parentNode.getAttribute("id");
	 
	 httpRequest.addEventListener("load", function() {
		 if(this.responseText === "success")
			 change(type,node);
	 });    
	 httpRequest.open("GET", "./TodoTypeServlet?id=" + id + "&type="+type);
	 httpRequest.send();
}