var prevScrollPos = window.pageYOffset;

window.onscroll = function() {
    var currentScrollPos = window.pageYOffset;
    if (prevScrollPos > currentScrollPos) {
        // Скролл вверх
        document.getElementById("my-element").classList.remove("hidden");
    } else {
        // Скролл вниз
        document.getElementById("my-element").classList.add("hidden");
    }
    prevScrollPos = currentScrollPos;
}

let lastScrollPosition = 0;

window.addEventListener('scroll', function() {
    // Определяем направление скролла
    const currentScrollPosition = window.pageYOffset;
    const isScrollingDown = currentScrollPosition > lastScrollPosition;

    // Если скролл вниз, то перемещаем пользователя вниз страницы
    if (isScrollingDown) {
        window.scrollBy(0,10, {behavior: 'smooth'});

    }

    lastScrollPosition = currentScrollPosition;
});