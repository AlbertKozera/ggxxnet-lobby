window.addEventListener('load', (e) => {
    var sprite;
    sendHttpRequest('GET',
            'http://26.39.40.108/ggxxreload/sprites',
            'application/json')
        .then(responseData => {
            sprite = JSON.parse(responseData);
            drawSprite(sprite);
        })
})

const sendHttpRequest = (method, url, contentType, body) => {
    return fetch(url, {
            method: method,
            body: JSON.stringify(body),
            headers: {
                'Content-Type': contentType
            }
        }).then(response => {
            return response.text();
        })
        .catch(err => {
            console.log(err, err.data)
        })
}

function drawSprite(sprite) {
    var imgWidth = 168;
    var imgHeight = 272;
    document.getElementById('sprite-canvas').width = imgWidth;
    document.getElementById('sprite-canvas').height = imgHeight;

    var canvas = document.querySelector('#sprite-canvas');
    var context = canvas.getContext('2d');

    // to increase performance createImageData method
    // should be executed once e.g. before drawing
    var image = context.createImageData(canvas.width, canvas.height);
    var data = image.data;

    // draw sprite
    var x = 0;
    var y = 0;
    sprite.forEach(s => {
        if (y == imgHeight) {
            return;
        }
        drawPixel(x, y, s);
        x++;
        if (x == imgWidth) {
            x = 0;
           y++;
        }
    });
    swapBuffer();

    function drawPixel(x, y, color) {
        var roundedX = Math.round(x);
        var roundedY = Math.round(y);

        var index = 4 * (canvas.width * roundedY + roundedX);

        data[index + 0] = color.R;
        data[index + 1] = color.G;
        data[index + 2] = color.B;
        data[index + 3] = 255;
    }

    function swapBuffer() {
        context.putImageData(image, 0, 0);
    }
}
