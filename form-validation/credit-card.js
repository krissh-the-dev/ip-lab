const cardInput = document.querySelector("input.credit-card-input");
const result = document.querySelector("p#validation-result");
const button = document.querySelector("button");

const MASTER_CARD = /^5[1-5][0-9]{14}$|^2(?:2(?:2[1-9]|[3-9][0-9])|[3-6][0-9][0-9]|7(?:[01][0-9]|20))[0-9]{12}$/;
const VISA_CARD = /^4[0-9]{12}(?:[0-9]{3})?$/;
const MAESTRO_CARD = /^(5018|5081|5044|5020|5038|603845|6304|6759|676[1-3]|6799|6220|504834|504817|504645)[0-9]{8,15}$/;
let card;

button.addEventListener("click", (e) => {
  e.preventDefault();
  const { value } = cardInput;

  if (value.match(MASTER_CARD)) {
    card = "Mastercard";
  } else if (value.match(VISA_CARD)) {
    card = "Visa";
  } else if (value.match(MAESTRO_CARD)) {
    card = "Maestrocard";
  } else {
    card = "Invalid Card number";
  }

  result.innerHTML = card;
  result.style.color = card === "Invalid Card number" ? "red" : "green";
});
