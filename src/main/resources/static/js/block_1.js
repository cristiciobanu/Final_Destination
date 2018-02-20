$.ajax({
        url: '/qwe',
        type: "GET",
        dataType: 'json',
        cache: false,
        success: function(data) {
            alert($('data.image.web'));
            $('.bgTop').attr('src',data.image.web)}
        });
