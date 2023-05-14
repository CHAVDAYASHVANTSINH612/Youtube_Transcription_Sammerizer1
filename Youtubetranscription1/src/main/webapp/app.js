$(document).ready(function() {
    $('#shorten-form').submit(function(event) {
      event.preventDefault();
      var url = $('#url-input').val();
      $.ajax({
        url: '/shorten-url',
        type: 'POST',
        data: { url: url },
        success: function(response) {
          $('#result-text').text(response);
        }
      });
    });
  });
  