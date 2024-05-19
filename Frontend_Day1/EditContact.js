const profileImageInput = document.getElementById('profile-image');
const profilePic = document.querySelector('.profile-pic'); // Assuming there's only one element with class 'profile-pic'

profileImageInput.addEventListener('change', function() {
  const uploadedFile = this.files[0]; // Get the first selected file

  if (uploadedFile) {
    const reader = new FileReader();

    reader.onload = function(e) {
      profilePic.src = e.target.result; // Set the image source of the profile picture element
    };

    reader.readAsDataURL(uploadedFile); // Read the image data as a data URL
  }
});