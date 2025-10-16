<template>
  <v-container class="ma-0 pa-0" fluid>
    <v-img
      class="w-100"
      cover
      height="600"
      src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkPGpqfZsC4ABtvG8l78bNYzAVWNQFHISErw&s"
    >
      <!-- Dark overlay for better text readability -->
      <div class="hero-overlay">
        <div class="hero-content">
          <h1 class="text-h2 text-md-h1 font-weight-bold mb-4">MadrasahPro</h1>
          <p class="text-h6 text-md-h5 mb-8">Helping the ummah, one institution at a time</p>

          <div class="d-flex flex-column flex-sm-row ga-4 justify-center">
            <v-btn
              color="#059669"
              size="large"
              variant="flat"
            >
              Join Us
            </v-btn>
            <v-btn
              color="white"
              size="large"
              variant="outlined"
            >
              Our Courses
            </v-btn>
            <v-btn
              color="white"
              size="large"
              variant="outlined"
            >
              Our Events
            </v-btn>
          </div>
        </div>
      </div>
    </v-img>
  </v-container>
</template>

<script lang="ts" setup>
</script>

<style scoped>
.hero-overlay {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
}

.hero-content {
  text-align: center;
  color: white;
  padding: 2rem;
  max-width: 800px;
}
</style>
