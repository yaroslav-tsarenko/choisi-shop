var slides = document.querySelectorAll('.slide');
var pagination = document.querySelector('.pagination');
var prevArrow = document.querySelector('.prev');
var nextArrow = document.querySelector('.next');
var currentIndex = 0;

// Create pagination dots
for (var i = 0; i < slides.length; i++) {
    var dot = document.createElement('span');
    dot.classList.add('dot');
    if (i === currentIndex) {
        dot.classList.add('active');
    }
    pagination.appendChild(dot);
}

var dots = document.querySelectorAll('.dot');

function goToSlide(index) {
    slides.forEach(function (slide, i) {
        slide.style.transform = 'translateX(' + ((i - index) * 100) + '%)';
    });
    dots.forEach(function (dot, i) {
        dot.classList.toggle('active', i === index);
    });
}

function goToNextSlide() {
    currentIndex = (currentIndex + 1) % slides.length;
    goToSlide(currentIndex);
}

function goToPrevSlide() {
    currentIndex = (currentIndex - 1 + slides.length) % slides.length;
    goToSlide(currentIndex);
}

nextArrow.addEventListener('click', goToNextSlide);
prevArrow.addEventListener('click', goToPrevSlide);

setInterval(goToNextSlide, 5000);
