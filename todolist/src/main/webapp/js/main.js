/**
 * 
 */
function change(type,node){
	
}
function status(id, node){
	 var httpRequest = new XMLHttpRequest();
	 var type = node.parentNode.parentNode.getAttribute("id");
	 
	 httpRequest.addEventListener("load", function() {
		 if(this.responseText === "success")
			 change(type,node);
	 });    
	 httpRequest.open("GET", "http://www.example.org/getData?data=data");//must change 
	 httpRequest.send();
}