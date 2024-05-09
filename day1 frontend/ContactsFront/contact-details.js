document.addEventListener('DOMContentLoaded', function() {
    const urlParams = new URLSearchParams(window.location.search);
    const contactId = urlParams.get('id');
    document.getElementById('deleteButton').addEventListener('click', () => deleteContact(contactId));
    document.getElementById('editButton').addEventListener('click', () => editContact(contactId));
    fetchContactDetails(contactId);
});


function fetchContactDetails(contactId) {
    fetch(`http://localhost:8181/api/contacts/${contactId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(contact => {
            displayContactDetails(contact);
        })
        .catch(error => {
            console.error('Error fetching contact details:', error);
        });
}

function displayContactDetails(contact) {
    document.getElementById('contactName').textContent = `${contact.name}`;
    document.getElementById('contactEmail').textContent =  `${contact.email}`;
    document.getElementById('contactPhoneNumber').textContent =` ${contact.phoneNumber}`;
    document.getElementById('contactDOB').textContent =` ${contact.dob}`;
    document.getElementById('contactAddress').textContent = `${contact.address}`;
}
function editContact(contactId) {
    window.location.href = `edit-contact.html?id=${contactId}`;
}

function deleteContact(contactId) {
    if (confirm('Are you sure you want to delete this contact?')) {
        fetch(`http://localhost:8181/api/contacts/${contactId}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            window.location.href = 'HomePage.html';
        })
        .catch(error => {
            console.error('Error deleting contact:', error);
        });
    }
}