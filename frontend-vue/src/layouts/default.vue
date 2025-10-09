<template>
  <v-layout class="min-h-screen d-flex flex-column rounded-md border">
    <!-- App Bar -->
    <v-app-bar color="#059669" title="MadrasahPro">
      <template #prepend>
        <v-icon icon="$vuetify" />
      </template>

      <template #append>
        <!-- Menu Button on the right -->
        <v-btn icon @click="drawer = !drawer">
          <v-icon>mdi-menu</v-icon>
        </v-btn>
      </template>
    </v-app-bar>

    <!-- Navigation Drawer -->
    <v-navigation-drawer
      v-model="drawer"
      color="#059669"
      location="top"
      temporary
    >
      <v-list>
        <v-list-item title="Home" />
        <v-list-item title="Courses" />
        <v-list-item title="Events" />
        <v-list-item title="Contact Us" />
      </v-list>
    </v-navigation-drawer>

    <!-- Main Content -->
    <v-main class="flex-grow-1 d-flex align-center justify-center">
      <router-view />
    </v-main>

    <!-- Footer -->
    <v-footer
      class="text-center d-flex flex-column ga-2 py-4 w-full"
      color="#059669"
      height="1"
      style="max-height: 200px;"
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

      <div class="text-caption font-weight-regular opacity-80 text-white">
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
