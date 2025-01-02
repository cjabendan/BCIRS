# PurokLink (BDMS)

PurokLink is a comprehensive **Barangay Data Management System (BDMS)** designed to streamline the management of Purok data. The system facilitates efficient handling of resident information, barangay documents, and incident reporting. With PurokLink, barangay secretaries and purok leaders can focus on better decision-making and community engagement.

## Features

### 1. Resident Management

- Add, view, update, and archive resident information.
- Import resident data for seamless integration.

### 2. Document Handling

- Generate and print barangay documents such as certifications and reports.
  - **Note**: Generated documents, such as resident certifications, are for demonstration purposes only and are not official.

### 3. Incident Reporting

- Add and view incident reports.
- Admins can monitor incident statistics for actionable insights.

### 4. User Roles

- **Barangay Secretary**: Admins overseeing system data with the following capabilities:
  - Download resident data.
  - View population classifications and counts.
  - Generate PDF reports for all Purok residents or specific Puroks.
- **Purok Leaders**: Users managing resident and incident data and downloading reports.

## Technology Stack

- **Frontend**: Java Swing (NetBeans)
- **Backend**: Java
- **Database**: MySQL (via XAMPP)
- **Platform**: Desktop Application

## Installation

1. **Download the Project:**

   ```bash
   git clone https://github.com/cjabendan/PurokLink-BDMS.git
   ```

2. **Setup the Database:**

   - Open XAMPP and start MySQL.
   - Import the provided SQL file into your database.

3. **Run the Application:**

   - Open the project in NetBeans.
   - Compile and run the application.

## Usage

1. **Login:** Use the assigned credentials to log in.
2. **Navigate:** Access different sections like Residents, Documents, and Incidents.
3. **Manage Data:** Utilize the user-friendly interface to add, view, or update data.

---

## Roadmap

This project is currently incomplete, and the developer does not plan to continue its development.

### Phase 1: Core Features

- Finalize CRUD operations for resident management.
- Complete functionality for generating PDF reports for all Purok residents and specific Puroks.
- Implement basic incident reporting.

### Phase 2: Enhancements

- Add user authentication with role-based access.
- Design and integrate a dashboard for population statistics and classifications.
- Optimize database queries for faster performance.

### Phase 3: Advanced Features

- Develop advanced reporting features, including export options for detailed analytics.
- Add support for real-time syncing between multiple devices.
- Include additional document templates for barangay certifications.

---

## Disclaimer

PurokLink is a school project focusing on CRUD (Create, Read, Update, Delete) operations, reports, statistics, and PDF generation. It is not intended for production use in official barangay operations.

---

Thank you for choosing PurokLink for your Barangay Data Management needs!

