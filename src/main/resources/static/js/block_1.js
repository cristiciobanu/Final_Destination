$.ajax({
        url: '/qwe',
        type: "GET",
        dataType: 'json',
        cache: false,
        success: function(data) {
            $('.townIMG').attr('src',data.photos[0].image.mobile)}
        });
