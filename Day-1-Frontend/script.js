document.addEventListener('DOMContentLoaded', function () {
    const contactsList = document.getElementById('contacts-list');
    const searchBox = document.getElementById('search-box');
    const sortButton = document.getElementById('sort-icon');
    const pageButtonsContainer = document.querySelector('.pagination');

    let currentPage = 1;
    let contactsPerPage = 5;
    let allContacts = []; 
    let sortOrder = 'asc'; 

    function fetchAllContacts() {
      fetch(`http://localhost:8181/api/contacts`)
        .then(response => response.json())
        .then(data => {
          allContacts = data;
          renderContacts();
        })
        .catch(error => console.error('Error fetching contacts:', error));
    }

    function renderContacts() {
      contactsList.innerHTML = '';

      let filteredContacts = allContacts;
      const searchValue = searchBox.value.trim().toLowerCase();
      if (searchValue !== '') {
        filteredContacts = allContacts.filter(contact =>
          contact.name.toLowerCase().includes(searchValue)
        );
      }
      filteredContacts.sort((a, b) => {
        if (sortOrder === 'asc') {
          return a.name.localeCompare(b.name); 
        } else {
          return b.name.localeCompare(a.name); 
        }
      });

      const startIndex = (currentPage - 1) * contactsPerPage;
      const endIndex = startIndex + contactsPerPage;
      const contactsToDisplay = filteredContacts.slice(startIndex, endIndex);

      if (contactsToDisplay.length === 0) {
        document.getElementById('no-contacts').style.display = 'block';
        return;
      }

      document.getElementById('no-contacts').style.display = 'none';

      contactsToDisplay.forEach(contact => {
        const listItem = document.createElement('li');
        listItem.classList.add('contact-item');
        listItem.innerHTML = `
          <div>
            <span class="contact-name">${contact.name}</span><br>
            <span class="contact-number">${contact.phoneNumber}</span> <!-- Corrected to display phone number -->
          </div>`;
        listItem.addEventListener('click', () => showContactDetails(contact.id)); 
        contactsList.appendChild(listItem);
      });

      renderPagination();
    }

    function showContactDetails(contactId) {
      const editContactPageUrl = `Contact.html?id=${contactId}`;
      window.location.href = editContactPageUrl;
    }

    function renderPagination() {
      pageButtonsContainer.innerHTML = '';

      const totalPages = Math.ceil(allContacts.length / contactsPerPage);

      for (let i = 1; i <= totalPages; i++) {
        const button = document.createElement('button');
        button.classList.add('page-button');
        button.textContent = i;
        button.dataset.page = i;
        button.addEventListener('click', function () {
          currentPage = parseInt(this.dataset.page);
          renderContacts();
        });
        pageButtonsContainer.appendChild(button);
      }

      document.getElementById('prev-page').disabled = currentPage === 1;
      document.getElementById('next-page').disabled = currentPage === totalPages;
    }

    searchBox.addEventListener('input', function () {
      renderContacts();
    });

    sortButton.addEventListener('click', function () {
      sortOrder = sortOrder === 'asc' ? 'desc' : 'asc'; 
      renderContacts();
    });

    document.getElementById('prev-page').addEventListener('click', function () {
      if (currentPage > 1) {
        currentPage--;
        renderContacts();
      }
    });

    document.getElementById('next-page').addEventListener('click', function () {
      const totalPages = Math.ceil(allContacts.length / contactsPerPage);
      if (currentPage < totalPages) {
        currentPage++;
        renderContacts();
      }
    });

    fetchAllContacts();
});
