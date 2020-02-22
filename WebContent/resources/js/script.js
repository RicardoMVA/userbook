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
      }
    })
  })
}
