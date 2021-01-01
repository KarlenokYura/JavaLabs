let role;

function getRole() {
    let username ,password;
    if (document.getElementById('authUsername') != null)
        username = document.getElementById('authUsername').value;
    else
        username = 'client';
    if (document.getElementById('authPassword') != null)
        password = document.getElementById('authPassword').value;
    else
        password = 'password';
    fetch('/Lab_18/Users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    }).then(res => res.json()).then(res => {
        if (res) {
            if (res == "error") {
                alert("Enter correct username and password");
                role = 'client';
            }
            else {
                role = res;
                clearContent('form');
            }
            visibilityButtons();
        }
    })
}

function signOut() {
    fetch('/Lab_18/Users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: 'reset',
            password: 'reset'
        })
    }).then(res => res.json()).then(res => {
        if (res) {
            role = res;
            visibilityButtons();
        }
    })
}

function adminLogin() {
    fetch('/Lab_18/Users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: 'admin',
            password: 'password'
        })
    }).then(res => res.json()).then(res => {
        if (res) {
            role = res;
            visibilityButtons();
        }
    })
}

function visibilityButtons() {
    let buttons = `<input type="button" value="filter" onclick="visibilityFilterForm()">`;
    if (role == 'client')
    	buttons += `<input type="button" class="admin" value="admin" onclick="adminLogin()">`;
    if (role == 'admin')
        buttons += `<input type="button" value="insert" onclick="visibilityInsertForm()"><input type="button" value="logout" onclick="signOut()">`
    document.getElementById('buttons').innerHTML = buttons;
    getReferences();
}

function visibilityInsertForm() {
    let form = `<p>url:<input type="text" id="url"></p>
            <p>description:<input type="text" id="description"></p>
            <p>
                <input type="button" onclick="addReference()" value="add"><input type="button" onclick="clearContent('form')" value="Cancel">
            </p>`
    document.getElementById("form").innerHTML = form;
}

function visibilityCommentsInsertForm(id) {
    let needId = "insertComment"+id;
    let form = `<p>comment:<input type="text" id="comment"></p>
                <p>
                    <input type="button" onclick="addComment(${id})" value="add"><input type="button" value="cancel" onclick="clearContent('insertComment${id}')">
                </p>`
    document.getElementById(needId).innerHTML = form;
}

function visibilityFilterForm() {
    let form = `<p>description:<input type="text" id="filterDescription"></p>
                <p>
                    <input type="button" onclick="getReferences()" value="filter"><input type="button" onclick="clearContent('form')" value="Cancel">
                </p>`
    document.getElementById("form").innerHTML = form;
}

function updateContentVisibility(id,url,description) {
    let form = `<table>
                    <tr><td>
                        <p>url:<input type="text" id="editUrl" value="${url}" ></p>
                        <p>description:<input type="text" id="editDescription" value="${description}"></p>
                        <p>
                            <input type="button" onclick="updateReference(${id})" value="update"><input type="button" value="cancel" onclick="clearContent(${id})">
                        </p>
                    </td></tr>
            </table>`
    document.getElementById(id).innerHTML = form;
}

function deleteContentVisibility(id) {
    let attention = `<table>
                        <tr><td>
                            You sure to delete reference with id ${id} 
                            <input type="button" value="yes" onclick="deleteReference(${id})"><input type="button" value="cancel" onclick="clearContent(${id})">
                        </td></tr>
                     </table>`;
    document.getElementById(id).innerHTML = attention;
}

function clearContent(id) {
    document.getElementById(id).innerHTML = "";
}

