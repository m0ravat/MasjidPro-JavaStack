<template>
  <v-app-bar color="#059669" elevation="2">
    <template #prepend>
      <router-link class="text-decoration-none align-center text-white d-flex" to="/">
        <v-icon class="mr-2" icon="$vuetify" />
        <v-toolbar-title>MadrasahPro</v-toolbar-title>
      </router-link>
    </template>

    <!-- Desktop Navigation - Hidden on mobile -->
    <template #default>
      <v-spacer />
      <div class="d-none d-md-flex align-center justify-center">
        <v-btn
          v-for="item in navItems"
          :key="item.title"
          class="text-white mx-1"
          :prepend-icon="item.icon"
          rounded="lg"
          :to="item.to"
          variant="text"
        >
          {{ item.title }}
        </v-btn>
      </div>
      <v-spacer />

      <!-- Add Portal button on the right -->
      <v-btn
        class="text-white mx-1 d-none d-md-flex"
        prepend-icon="mdi-login"
        rounded="lg"
        to="/portal"
        variant="text"
      >
        Portal
      </v-btn>
    </template>

    <!-- Mobile Menu Button - Hidden on desktop -->
    <template #append>
      <v-btn
        class="d-md-none"
        icon
        @click="drawer = !drawer"
      >
        <v-icon>mdi-menu</v-icon>
      </v-btn>
    </template>
  </v-app-bar>

  <!-- Mobile Navigation Drawer -->
  <v-navigation-drawer
    v-model="drawer"
    class="d-md-none"
    color="#059669"
    location="right"
    temporary
  >
    <v-list nav>
      <v-list-item
        v-for="item in navItems"
        :key="item.title"
        :prepend-icon="item.icon"
        :title="item.title"
        :to="item.to"
        @click="drawer = false"
      />
      <!-- Add Portal to mobile drawer -->
      <v-list-item
        prepend-icon="mdi-login"
        title="Portal"
        to="/portal"
        @click="drawer = false"
      />
    </v-list>
  </v-navigation-drawer>
</template>

<script setup>
  const navItems = [
    { title: 'Home', icon: 'mdi-home', to: '/' },
    { title: 'Courses', icon: 'mdi-folder', to: '/courses' },
    { title: 'Events', icon: 'mdi-folder', to: '/events' },
    { title: 'Contact Us', icon: 'mdi-phone', to: '/contact' },
  ]
</script>
