function run(){
    var appContainer = document.getElementsByClassName('todos')[0];
    appContainer.addEventListener('click', delegateEvent);
}

function delegateEvent(evtObj) {
    if(evtObj.type==='click' && evtObj.target.classList.contains('getButton')){
        print(getAllUsers());
        printDiv(getAllUsers());
    }

    if(evtObj.type==='click' && evtObj.target.classList.contains('printButton')){
        var input = document.getElementsByClassName("todo-input");
        print(input.value());
        printDiv(input.value());
    }
}

function getAllUsers(){
    var  http =  new XMLHttpRequest();
    http.open("GET","localhost:8080/usemaps/user/5",false);
    http.onreadystatechange = function() {
        if (http.readyState === 4 && http.status === 200) {
            return http.responseText;
        } else {
            return "Beg, but it's work"
        }
    }
}

function print(text){
    var tableItem=document.createElement('table');
    var tr=document.createElement('tr');

    var tdMessage=document.createElement('td');
    tdMessage.classList.add('message');
    tdMessage.appendChild(document.createTextNode(text));

    tr.appendChild(tdMessage);

    tableItem.appendChild(tr);
    var items=document.getElementsByClassName("message-history")[0];
    items.appendChild(tableItem);
}

function printDiv(text){
    var div = document.getElementsByClassName("printJSON");
    div.innerHTML = text;
}