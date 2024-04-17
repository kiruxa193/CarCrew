// Функция для валидации поля имени
console.log("я жив");
function validateName(name) {
    // Проверяем, что поле не пустое и состоит только из букв
    return /^[a-zA-Zа-яВ-Я]+$/.test(name);
}

// Функция для валидации поля фамилии
function validateSurname(surname) {
    // Проверяем, что поле не пустое, состоит только из букв
    // и имеет только одну заглавную букву
    return /^[A-Z][a-z]+$/.test(surname);
}

// Функция для валидации поля по маске
function validateMaskedField(value, mask) {
    // Проверяем, что значение соответствует маске
    return new RegExp(mask).test(value);
}

// Функция для валидации поля на минимальное и максимальное значение
function validateMinMaxValue(value, minValue, maxValue) {
    // Проверяем, что значение находится в заданном диапазоне
    return value >= minValue && value <= maxValue;
}




const form = document.querySelector('form');
const nameField = document.querySelector('#name');
const surnameField = document.querySelector('#surname');

// Обрабатываем отправку формы
form.addEventListener('submit', function(event) {
    // Отменяем отправку формы по умолчанию
    event.preventDefault();

    // Получаем значения полей формы
    const name = nameField.value.trim();
    const surname = surnameField.value.trim();

    // Валидируем поля формы
    if (!validateName(name)) {
        alert('Введите корректное имя');
        return;
    }

    if (!validateSurname(surname)) {
        alert('Введите корректную фамилию');
        return;
    }


    // Если все поля прошли валидацию, отправляем форму
    console.log("это конец");
    form.submit();

});