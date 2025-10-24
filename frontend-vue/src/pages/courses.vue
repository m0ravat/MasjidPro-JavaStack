<template>
  <div class="courses">
    <!-- Page Header -->
    <v-container class="py-12">
      <div class="header-line" />
      <h1 class="text-h2 font-weight-bold mt-4 mb-8">Available Courses</h1>

      <!-- Courses Grid -->
      <v-row>
        <v-col
          v-for="{id, title, image, badge, description, eligibility, price, duration} in courseStore.courses"
          :key="id"
          cols="12"
          md="6"
        >
          <v-card class="course-card" elevation="2" hover :to="`/apply`">
            <!-- Course Image -->
            <v-img
              class="course-image"
              cover
              height="300"
              :src="image"
            />

            <!-- Course Content -->
            <v-card-text class="pa-6">
              <!-- Badge -->
              <v-chip
                class="mb-4"
                color="black"
                size="default"
                text-color="white"
              >
                {{ badge }}
              </v-chip>

              <!-- Course Title -->
              <h2 class="text-h4 font-weight-bold mb-3">
                {{ title }}
              </h2>

              <!-- Course Description -->
              <p class="text-body-1 mb-0">
                {{ description }}
                <span class="font-weight-bold">Read more ...</span>
              </p>
            </v-card-text>

            <!-- Course Info Footer -->
            <v-divider />
            <v-card-text class="pa-0">
              <v-row class="course-info" no-gutters>
                <v-col class="text-center pa-4" cols="4">
                  <div class="font-weight-medium">{{ eligibility }}</div>
                </v-col>
                <v-divider vertical />
                <v-col class="text-center pa-4" cols="4">
                  <div class="font-weight-medium">{{ duration }}</div>
                </v-col>
                <v-divider vertical />
                <v-col class="text-center pa-4" cols="4">
                  <div class="font-weight-medium">{{ price }}</div>
                </v-col>
              </v-row>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script lang="ts" setup>
import {useCourseStore} from "@/stores/app.ts";
const courseStore = useCourseStore()
</script>

<style scoped>
.courses-page {
  background-color: #f5f5f5;
  min-height: 100vh;
}

.header-line {
  width: 180px;
  height: 4px;
  background-color: #059669;
}

.course-card {
  height: 100%;
  display: flex;
  flex-direction: column;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.course-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15) !important;
}

.course-image {
  border-radius: 4px 4px 0 0;
}

.course-info {
  font-size: 0.95rem;
}
</style>
