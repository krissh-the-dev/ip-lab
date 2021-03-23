const name = document.querySelector("input#name");
const gender = document.querySelector("input#gender");
const dob = document.querySelector("input#dob");

const email = document.querySelector("input#email");
const password = document.querySelector("input#password");
const cPassword = document.querySelector("input#c-password");

const errors = document.querySelector("p.errors");

const submitButton = document.querySelector("button");

submitButton.addEventListener("click", (ev) => {
  ev.preventDefault();
  let errorString = "";
  if (name.value.length < 3 || name.value.length >= 30) {
    errorString += "Name is too short or lengthy.";
  }
  if (new Date(dob.value) > new Date("2002-01-01")) {
    errorString += "\nYou're too young.";
  }
  if (!email.value.match(/^[^\s@]+@[^\s@]+$/)) {
    errorString += "\nInvalid email.";
  }

  if (password.value !== cPassword.value) {
    errorString += "\nPassword and confirm password mismatch.";
  }

  if (
    !password.value.match(
      "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8}$"
    )
  ) {
    errorString += "\nWeak password";
  }

  errors.innerHTML = errorString;
});
