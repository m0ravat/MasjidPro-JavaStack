<template>
  <div class="bg-grey-lighten-4">
    <v-container class="py-12">
      <!-- Decorative line and heading -->
      <div class="mb-8">
        <div class="bg-emerald-600" style="width: 180px; height: 4px; margin-bottom: 24px;" />
        <h1 class="text-h3 font-weight-bold">Upcoming Events</h1>
      </div>

      <!-- Events Grid -->
      <v-row>
        <v-col
          v-for="event in events"
          :key="event.eventID"
          cols="12"
          md="6"
        >
          <v-card
            class="h-100 d-flex flex-column"
            elevation="2"
            hover
            :to="`/events/${event.eventID}`"
          >
            <!-- Event Image -->
            <v-img
              class="bg-grey-lighten-2"
              cover
              height="300"
              :src="event.image"
            />

            <!-- Event Content -->
            <v-card-text class="flex-grow-1 d-flex flex-column pa-6">
              <!-- Date Badge -->
              <v-chip
                class="mb-4"
                color="black"
                size="small"
                style="width: fit-content;"
                text-color="white"
              >
                {{ event.dateInfo }}
              </v-chip>

              <!-- Event Title -->
              <h2 class="text-h5 font-weight-bold mb-3">
                {{ event.title }}
              </h2>

              <!-- Short Description -->
              <p class="text-body-1 mb-4">
                {{ event.shortDesc }}
              </p>

              <!-- More Info Link -->
              <v-btn
                class="px-0 justify-start"
                color="emerald-600"
                style="text-transform: none;"
                variant="text"
              >
                More Info
                <v-icon end>mdi-arrow-right</v-icon>
              </v-btn>
            </v-card-text>

            <!-- Event Info Footer -->
            <v-divider />
            <v-card-text class="pa-0">
              <v-row class="text-center" no-gutters>
                <v-col class="pa-4 border-e" cols="4">
                  <div class="text-caption text-grey-darken-1 mb-1">Time</div>
                  <div class="font-weight-bold">{{ event.timeInfo }}</div>
                </v-col>
                <v-col class="pa-4 border-e" cols="4">
                  <div class="text-caption text-grey-darken-1 mb-1">Open To</div>
                  <div class="font-weight-bold">{{ event.openTo }}</div>
                </v-col>
                <v-col class="pa-4" cols="4">
                  <div class="text-caption text-grey-darken-1 mb-1">Location</div>
                  <div class="font-weight-bold">{{ event.location }}</div>
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
  interface Event {
    eventID: number
    title: string
    shortDesc: string
    dateInfo: string
    timeInfo: string
    openTo: string
    eventDesc: string
    relevantLinks: string
    image: string
    location: string
  }

  const events: Event[] = [
    {
      eventID: 1,
      title: 'Annual Islamic Conference',
      shortDesc: 'Join us for our annual conference featuring renowned scholars discussing contemporary Islamic issues and spiritual development.',
      dateInfo: 'Saturday, 15th March 2025',
      timeInfo: '9:00 AM - 5:00 PM',
      openTo: 'All',
      eventDesc: 'Our annual Islamic conference brings together scholars, students, and community members for a day of learning and spiritual growth. The event features keynote speeches, panel discussions, and workshops covering various aspects of Islamic knowledge and practice.',
      relevantLinks: 'https://example.com/conference',
      image: 'https://images.unsplash.com/photo-1591604466107-ec97de577aff?w=800',
      location: 'Main Hall',
    },
    {
      eventID: 2,
      title: 'Quranic Recitation Competition',
      shortDesc: 'Showcase your Quranic recitation skills in our annual competition with prizes for winners in different age categories.',
      dateInfo: 'Friday, 28th March 2025',
      timeInfo: '6:00 PM - 9:00 PM',
      openTo: 'Students',
      eventDesc: 'An opportunity for students to demonstrate their mastery of Quranic recitation. Judges will evaluate based on tajweed, melody, and overall presentation. Multiple age categories ensure fair competition.',
      relevantLinks: 'https://example.com/competition',
      image: 'https://images.unsplash.com/photo-1609599006353-e629aaabfeae?w=800',
      location: 'Auditorium',
    },
    {
      eventID: 3,
      title: 'Family Open Day',
      shortDesc: 'Explore our facilities, meet our teachers, and learn about our programs in this special family-friendly open day event.',
      dateInfo: 'Sunday, 6th April 2025',
      timeInfo: '10:00 AM - 3:00 PM',
      openTo: 'Families',
      eventDesc: 'Bring your family to explore MadrasahPro! Tour our facilities, meet our dedicated teaching staff, attend sample classes, and learn about our comprehensive Islamic education programs. Refreshments will be provided.',
      relevantLinks: 'https://example.com/openday',
      image: 'https://images.unsplash.com/photo-1511632765486-a01980e01a18?w=800',
      location: 'Campus Wide',
    },
    {
      eventID: 4,
      title: 'Ramadan Preparation Workshop',
      shortDesc: 'Prepare spiritually and practically for the blessed month of Ramadan with guidance from experienced scholars.',
      dateInfo: 'Saturday, 12th April 2025',
      timeInfo: '2:00 PM - 5:00 PM',
      openTo: 'All',
      eventDesc: 'A comprehensive workshop to help you maximize the blessings of Ramadan. Topics include fasting guidelines, spiritual preparation, Taraweeh prayers, and practical tips for maintaining productivity during the blessed month.',
      relevantLinks: 'https://example.com/ramadan',
      image: 'https://images.unsplash.com/photo-1542816417-0983c9c9ad53?w=800',
      location: 'Lecture Hall',
    },
  ]
</script>

<style scoped>
.bg-emerald-600 {
  background-color: #059669;
}

.text-emerald-600 {
  color: #059669;
}

.border-e {
  border-right: 1px solid rgba(0, 0, 0, 0.12);
}
</style>
