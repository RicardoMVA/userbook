const putForm = document.getElementById("putForm");

if (putForm != null) {
  const urlParams = new URLSearchParams(window.location.search);
  const userId = urlParams.get('id');
  const putFormBtn = document.getElementById("putFormBtn");

  putFormBtn.addEventListener("click", (e) => {
    e.preventDefault();

    $.ajax({
      type: 'PUT',
      url: '/users/edit?id=' + userId,
      data: $(putForm).serialize(),
      success: function(result) {
        window.location = '/';
      },
      error: function(result) {
        console.log(result.responseText);
      }
    })
  })
}

const deleteBtns = document.querySelectorAll(".deleteBtn");

if (deleteBtns != null) {
  deleteBtns.forEach((button) => {

    button.addEventListener("click", (e) => {
      const userId = e.srcElement.parentNode.children[2].value

      $.ajax({
        type: 'DELETE',
        url: '/users/delete?id=' + userId,
        success: function(result) {
          window.location = '/';
        },
        error: function(result) {
          console.log(result.responseText);
        }
      })
    })
  })
}

const addPhone = document.getElementById("addPhone");

if (addPhone != null) {
  addPhone.addEventListener("click", (e) => {
    const phonesList = document.getElementById("phonesList");
    const phoneForm = document.getElementById("phoneForm");
    
    const newPhone = phoneForm.cloneNode(true);

    phonesList.appendChild(newPhone);
  });
}