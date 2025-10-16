<template>
  <v-layout class="d-flex flex-column">
    <!-- App Bar -->
    <generic-nav />

    <!-- Main Content - removed align-center justify-center to allow scrolling -->
    <v-main class="flex-grow-1">
      <router-view />
    </v-main>

    <!-- Footer - removed height constraints -->
    <v-footer
      class="text-center d-flex flex-column ga-2 py-4"
      color="#059669"
    >
      <!-- Social icons -->
      <div class="d-flex ga-3 justify-center">
        <v-btn
          v-for="icon in icons"
          :key="icon"
          color="white"
          density="comfortable"
          :icon="icon"
          variant="text"
        />
      </div>

      <v-divider class="my-2" thickness="2" width="50" />

      <div class="text-caption font-weight-regular opacity-80 text-white px-4">
        Phasellus feugiat arcu sapien, et iaculis ipsum elementum sit amet.
        Mauris cursus commodo interdum. Praesent ut risus eget metus luctus
        accumsan id ultrices nunc. Sed at orci sed massa consectetur dignissim a
        sit amet dui. Duis commodo vitae velit et faucibus.
      </div>

      <v-divider class="my-2" />

      <div class="text-white">
        {{ new Date().getFullYear() }} — <strong>MadrasahPro</strong>
      </div>
    </v-footer>
  </v-layout>
</template>

<script setup lang="ts">
  import { ref } from 'vue'

  const drawer = ref(false)
  const icons = [
    'mdi-youtube',
    'mdi-facebook',
    'mdi-twitter',
    'mdi-instagram',
  ]
</script>
