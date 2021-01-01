function getCommentForReference(id) {
    fetch('/Lab_18/Comments?refId='+id, {
        method: 'GET'
    }).then(res => res.json()).then(res => {
        let data = `<table>
                    <tr><td>
                        <h1>--UWSR comments/${id}--</h1>
                        <input type="button" onclick="visibilityCommentsInsertForm(${id})" value="insert"><input type="button" onclick="clearContent(${id})" value="cansel"><div id="insertComment${id}"></div>
                    </td></tr>
                </table>`
        if (res) {
            res.forEach(element =>{
                let comments = `<table><tr><td>[${element.stamp}]`
                if(role == 'admin' || element.sessionId == sessionId)
                    comments += `<input type="button" value="delete" onclick="deleteComment(${element.id},${element.refId})"><input type="button" value="update" onclick="updateComment(${element.id},${element.refId})"><textarea id="txt${element.id}">${element.comment}</textarea>`
                else
                    comments+= `<textarea readonly id="txt${element.id}">${element.comment}</textarea></td></tr></table>`
                data += comments;
            })
        }
        document.getElementById(id).innerHTML = data;
    })
}


function addComment(id) {
    fetch('/Lab_18/Comments', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            comment: document.getElementById('comment').value,
            refId: id,
            sessionId : sessionId
        })
    }).then(()=>{
        clearContent(id);
        getCommentForReference(id);
    })
}

function updateComment(id,refId) {
    let needId = 'txt'+id;
    fetch('/Lab_18/Comments', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: id,
            comment: document.getElementById(needId).value
        })
    }).then(()=>{
        getCommentForReference(refId);
    })
}

function deleteComment(id,refId) {
    fetch('/Lab_18/Comments?id='+id,{
        method : 'DELETE'
    }).then(()=>{
        getCommentForReference(refId);
    })
}