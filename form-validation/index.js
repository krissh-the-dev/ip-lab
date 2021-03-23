const nameInput = document.querySelector("input#name");
const genderInput = document.querySelector("input#gender");
const dobInput = document.querySelector("input#dob");

const emailInput = document.querySelector("input#email");
const passwordInput = document.querySelector("input#password");
const cPasswordInput = document.querySelector("input#c-password");

const errors = document.querySelector("p.errors");

const submitButton = document.querySelector("button");

submitButton.addEventListener("click", function (ev) {
  ev.preventDefault(); // prevent next page load
  let errorString = "";
  if (nameInput.value.length < 3 || nameInput.value.length >= 30) {
    errorString += "Name is too short or lengthy.";
  }
  if (new Date(dobInput.value) > new Date("2002-01-01")) {
    errorString += "\nYou're too young.";
  }
  if (!emailInput.value.match(/^[^\s@]+@[^\s@]+$/)) {
    //regex
    errorString += "\nInvalid email.";
  }

  if (passwordInput.value !== cPasswordInput.value) {
    errorString += "\nPassword and confirm password mismatch.";
  }

  if (passwordInput.value.length < 6) {
    errorString += "\nWeak password";
  }

  if (errorString === "") {
    errorString = "Validation successful.";
    alert("Successfully registered.");
  }

  errors.innerHTML = errorString;
});

//!password.value.match(
// /^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*].*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$/
// )

// /^ $/
