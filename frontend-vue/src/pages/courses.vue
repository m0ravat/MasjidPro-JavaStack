<template>
  <div class="courses">
    <!-- Page Header -->
    <v-container class="py-12">
      <div class="header-line" />
      <h1 class="text-h2 font-weight-bold mt-4 mb-8">Available Courses</h1>

      <!-- Courses Grid -->
      <v-row>
        <v-col
          v-for="{id, title, image, badge, description, eligibility, price, duration} in courses"
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
  import { ref } from 'vue'

  const courses = ref([
    {
      id: 1,
      title: '\'Alimiyyah Course',
      badge: 'Onsite | Weekdays',
      description: 'The IZA \'Ālimiyyah Course was designed from the traditional Darse Nizami course catering to the Muslim community of U.K.',
      image: 'https://images.unsplash.com/photo-1591604466107-ec97de577aff?w=800&h=600&fit=crop',
      eligibility: 'Males 16+',
      duration: '7 years',
      price: '£1200/annually',
    },
    {
      id: 2,
      title: 'Diploma in Islamic Studies',
      badge: 'Onsite | Weekdays',
      description: 'The Diploma course was designed for the busy Muslim adult. The course has been carefully designed, covering a wide range of modules.',
      image: 'https://images.unsplash.com/photo-1584286595398-a59f21d25e46?w=800&h=600&fit=crop',
      eligibility: 'Males 16+',
      duration: '2 years',
      price: '£60/month',
    },
    {
      id: 3,
      title: 'The Qur\'an Programme',
      badge: 'Onsite | Weekdays',
      description: 'A comprehensive programme designed to help students master Quranic recitation with proper tajweed and memorization techniques.',
      image: 'https://images.unsplash.com/photo-1609599006353-e629aaabfeae?w=800&h=600&fit=crop',
      eligibility: 'All Ages',
      duration: '3 years',
      price: '£800/annually',
    },
    {
      id: 4,
      title: 'GCSE in Islamic Studies',
      badge: 'Onsite | Weekdays',
      description: 'Prepare for your GCSE in Islamic Studies with our structured curriculum aligned with examination board requirements.',
      image: 'https://images.unsplash.com/photo-1524995997946-a1c2e315a42f?w=800&h=600&fit=crop',
      eligibility: 'Ages 14-16',
      duration: '2 years',
      price: '£500/annually',
    },
  ])
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
