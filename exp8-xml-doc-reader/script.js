function readXMLData() {
  let xmlDocumentObject = new XMLHttpRequest();
  xmlDocumentObject.open("GET", "user_info.xml", false);
  xmlDocumentObject.send();
  xmlDocumentObject = xmlDocumentObject.responseXML;
  const id = xmlDocumentObject.getElementsByTagName("UserID");
  const name = xmlDocumentObject.getElementsByTagName("UserName");
  const phone = xmlDocumentObject.getElementsByTagName("UserPhone");
  for (i = 0; i < id.length; i++) {
    output = id[i].firstChild.nodeValue;
    if (output == document.getElementById("myText").value) {
      document.getElementById("displayDIV").innerHTML = `
					<p>ID: ${id[i].firstChild.nodeValue}</p>
					<p>Name: ${name[i].firstChild.nodeValue}</p>
					<p>Phone: ${phone[i].firstChild.nodeValue}</p>`;
    }
  }
}
