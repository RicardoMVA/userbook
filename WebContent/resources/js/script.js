// logic for rendering alert box
const alertContainer = document.getElementById("alert-container");
const closeBox = document.querySelector(".close-box");

closeBox.addEventListener("click", (e) => {
  alertContainer.classList.remove('floating-alert-display');
  alertContainer.classList.add('floating-alert-hide'); 
});

const renderAlertBox = (text, alertType) => {
  alertContainer.classList.remove('floating-alert-hide');
  alertContainer.classList.add('floating-alert-display');

  const alertBox = document.getElementById("alert-box");
  alertBox.classList.add(alertType);

  const alertText = document.getElementById("alert-text");
  alertText.innerHTML = text;

  document.getElementById("top").scrollIntoView();
}
// ==============================================

// checks if any alert message is present in current window
const urlParams = new URLSearchParams(window.location.search);
const alertMsg = urlParams.get('msg');

if (alertMsg != null) {
  const alertMsgType = urlParams.get('msgType');
  const destination = urlParams.get('urlDest');

  renderAlertBox(alertMsg, alertMsgType);

  history.replaceState({}, "", destination);
}

// ==============================================

// sends put request
const putForm = document.getElementById("putForm");

if (putForm != null) {
  const userId = urlParams.get('id');
  const putFormBtn = document.getElementById("putFormBtn");

  putFormBtn.addEventListener("click", (e) => {
    e.preventDefault();

    $.ajax({
      type: 'PUT',
      url: '/users/edit?id=' + userId,
      data: $(putForm).serialize(),
      success: function(result) {
        window.location = '/?msgType=alert-success&msg=User edited successfully!&urlDest=/';
      },
      error: function(result) {
        renderAlertBox(result.responseText, "alert-danger");
      }
    })
  })
}
// ==============================================

// sends delete request
const deleteBtns = document.querySelectorAll(".deleteBtn");

if (deleteBtns != null) {
  deleteBtns.forEach((button) => {

    button.addEventListener("click", (e) => {
      const userId = e.srcElement.parentNode.children[2].value

      $.ajax({
        type: 'DELETE',
        url: '/users/delete?id=' + userId,
        success: function(result) {
          window.location = '/?msgType=alert-success&msg=User deleted successfully!&urlDest=/';
        },
        error: function(result) {
          renderAlertBox(result.responseText, "alert-danger");
        }
      })
    })
  })
}
// ==============================================

// show multiple phone forms, used in 'create' and 'edit' pages
const addPhone = document.getElementById("addPhone");

if (addPhone != null) {
  addPhone.addEventListener("click", (e) => {
    const phonesList = document.getElementById("phonesList");
    const phoneForm = document.getElementById("phoneForm");
    
    const newPhone = phoneForm.cloneNode(true);

    phonesList.appendChild(newPhone);
  });
}
// ==============================================
