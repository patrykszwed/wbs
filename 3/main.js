function changeHTML() {
  const color = document.getElementById('changable').style.color;
  if (color !== 'red') {
    document.getElementById('changable').style.color = 'red';
  } else {
    document.getElementById('changable').style.color = 'blue';
  }
}

function spamConsole() {
  for (let i = 0; i < 20; i++) {
    console.log('Example logging...');
  }
}

function descInit() {
  document.getElementById('scriptOutput').value = desc(['String1', 'otherSTRING', 'MOREstrings']);
}

function changeClassInit() {
  changeClass('changable', 'This is new text and no more!');
}

function multiplyInit() {
  multiply('field1', 'field2', 'scriptOutput');
}

function changeTableInit() {
  changeTable('tableScript', 'Header from script');
}

function promptInit() {
  prompting('scriptOutput');
}

function desc(strArr) {
  let result = "";
  for (let i = 0; i < strArr.length; i++) {
    result += strArr[i].toUpperCase();
  }
  return result;
}

function changeClass(className, newHTML) {
  let el = document.getElementsByClassName(className);
  for (let i = 0; i < el.length; i++) {
    el[i].innerHTML = newHTML;
  }
}

function multiply(field1, field2, field3) {
  document.getElementById(field3).value = 
    document.getElementById(field1).value * document.getElementById(field2).value;
}

const maxLength = 80;

function changeTable(tableId, header) {
  if (header.length <= maxLength) {
    document.getElementById(tableId).getElementsByTagName('th')[0].innerHTML = header;
  }
}

function prompting(fieldId) {
  document.getElementById(fieldId).value = prompt("What's your name?");
}