$.ajax({
        url: '/qwe',
        type: "GET",
        dataType: 'json',
        cache: false,
        success: function(data) {
            $('.bgTop').attr('src',data.photos[0].image.mobile)}
        });
