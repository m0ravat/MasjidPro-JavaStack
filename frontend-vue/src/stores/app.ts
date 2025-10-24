// Utilities
import { defineStore } from 'pinia'

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

export const useEventStore = defineStore('event', () => {
  const events = ref<Event[]>([
    {
      eventID: 1,
      title: 'Annual Islamic Conference',
      shortDesc:
        'Join us for our annual conference featuring renowned scholars discussing contemporary Islamic issues and spiritual development.',
      dateInfo: 'Saturday, 15th March 2025',
      timeInfo: '9:00 AM - 5:00 PM',
      openTo: 'All',
      eventDesc:
        'Our annual Islamic conference brings together scholars, students, and community members for a day of learning and spiritual growth. The event features keynote speeches, panel discussions, and workshops covering various aspects of Islamic knowledge and practice.',
      relevantLinks: 'https://example.com/conference',
      image: 'https://images.unsplash.com/photo-1591604466107-ec97de577aff?w=800',
      location: 'Main Hall',
    },
    {
      eventID: 2,
      title: 'Quranic Recitation Competition',
      shortDesc:
        'Showcase your Quranic recitation skills in our annual competition with prizes for winners in different age categories.',
      dateInfo: 'Friday, 28th March 2025',
      timeInfo: '6:00 PM - 9:00 PM',
      openTo: 'Students',
      eventDesc:
        'An opportunity for students to demonstrate their mastery of Quranic recitation. Judges will evaluate based on tajweed, melody, and overall presentation. Multiple age categories ensure fair competition.',
      relevantLinks: 'https://example.com/competition',
      image: 'https://images.unsplash.com/photo-1609599006353-e629aaabfeae?w=800',
      location: 'Auditorium',
    },
    {
      eventID: 3,
      title: 'Family Open Day',
      shortDesc:
        'Explore our facilities, meet our teachers, and learn about our programs in this special family-friendly open day event.',
      dateInfo: 'Sunday, 6th April 2025',
      timeInfo: '10:00 AM - 3:00 PM',
      openTo: 'Families',
      eventDesc:
        'Bring your family to explore MadrasahPro! Tour our facilities, meet our dedicated teaching staff, attend sample classes, and learn about our comprehensive Islamic education programs. Refreshments will be provided.',
      relevantLinks: 'https://example.com/openday',
      image: 'https://images.unsplash.com/photo-1511632765486-a01980e01a18?w=800',
      location: 'Campus Wide',
    },
    {
      eventID: 4,
      title: 'Ramadan Preparation Workshop',
      shortDesc:
        'Prepare spiritually and practically for the blessed month of Ramadan with guidance from experienced scholars.',
      dateInfo: 'Saturday, 12th April 2025',
      timeInfo: '2:00 PM - 5:00 PM',
      openTo: 'All',
      eventDesc:
        'A comprehensive workshop to help you maximize the blessings of Ramadan. Topics include fasting guidelines, spiritual preparation, Taraweeh prayers, and practical tips for maintaining productivity during the blessed month.',
      relevantLinks: 'https://example.com/ramadan',
      image: 'https://images.unsplash.com/photo-1542816417-0983c9c9ad53?w=800',
      location: 'Lecture Hall',
    },
  ])

  return { events }
})

interface Course {
  id: number
  title: string
  badge: string
  description: string
  image: string
  eligibility: string
  duration: string
  price: string
}

export const useCourseStore = defineStore('course', () => {
  const courses = ref<Course[]>([
    {
      id: 1,
      title: "'Alimiyyah Course",
      badge: 'Onsite | Weekdays',
      description:
        "The IZA 'Ālimiyyah Course was designed from the traditional Darse Nizami course catering to the Muslim community of U.K.",
      image:
        'https://images.unsplash.com/photo-1591604466107-ec97de577aff?w=800&h=600&fit=crop',
      eligibility: 'Males 16+',
      duration: '7 years',
      price: '£1200/annually',
    },
    {
      id: 2,
      title: 'Diploma in Islamic Studies',
      badge: 'Onsite | Weekdays',
      description:
        'The Diploma course was designed for the busy Muslim adult. The course has been carefully designed, covering a wide range of modules.',
      image:
        'https://images.unsplash.com/photo-1584286595398-a59f21d25e46?w=800&h=600&fit=crop',
      eligibility: 'Males 16+',
      duration: '2 years',
      price: '£60/month',
    },
    {
      id: 3,
      title: "The Qur'an Programme",
      badge: 'Onsite | Weekdays',
      description:
        'A comprehensive programme designed to help students master Quranic recitation with proper tajweed and memorization techniques.',
      image:
        'https://images.unsplash.com/photo-1609599006353-e629aaabfeae?w=800&h=600&fit=crop',
      eligibility: 'All Ages',
      duration: '3 years',
      price: '£800/annually',
    },
    {
      id: 4,
      title: 'GCSE in Islamic Studies',
      badge: 'Onsite | Weekdays',
      description:
        'Prepare for your GCSE in Islamic Studies with our structured curriculum aligned with examination board requirements.',
      image:
        'https://images.unsplash.com/photo-1524995997946-a1c2e315a42f?w=800&h=600&fit=crop',
      eligibility: 'Ages 14-16',
      duration: '2 years',
      price: '£500/annually',
    },
  ])

  return { courses }
})
