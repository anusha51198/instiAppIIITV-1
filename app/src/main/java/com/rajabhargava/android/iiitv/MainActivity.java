package com.rajabhargava.android.iiitv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    final String TAG = "MainActivity";

    private DrawerLayout dl;
    private ActionBarDrawerToggle adt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        dl = (DrawerLayout) findViewById(R.id.dl_main);
        adt = new ActionBarDrawerToggle(this,dl,R.string.open,R.string.close);
        adt.setDrawerIndicatorEnabled(true);
        MenuItem last;

        dl.addDrawerListener(adt);
        adt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_main);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();

                if(id == R.id.menu_about)
                {
                    Toast.makeText(MainActivity.this,"About",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_hec) {
                    Toast.makeText(MainActivity.this,"HEC Guilidelines",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_cal) {
                    Toast.makeText(MainActivity.this,"Academic Calendar",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_timetable){
                    Toast.makeText(MainActivity.this,"Time Table",Toast.LENGTH_SHORT).show();
                }
                else if(id == R.id.menu_Hlist){
                    Toast.makeText(MainActivity.this,"gdrive",Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });

        Button courses = (Button) findViewById(R.id.b_courses);

        final Intent i = new Intent(this,BranchActivity.class);

        courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });


        // CS Semester 1 Introduction to Discrete Mathematics details
//                Map<String, Object> cs1c1 = new HashMap<>();
//                cs1c1.put("Course Contents", "FOUNDATION: Propositional and predicate logic, logical equivalences, predicates and quantifiers,\n" +
//                        "translation from language to logical expressions, nested quantifiers, set theory, set operations, set identities and\n" +
//                        "functions, inverse and composition functions, graph of functions.\n" +
//                        "NUMBER THEORY: Division operator, prime factorization, properties of prime numbers, prime number theorem,\n" +
//                        "GCD and LCM, modular arithmetic and applications, sequences and summations.\n" +
//                        "COUNTING: Permutation and combinations, pigeonhole principle, inclusion-exclusion principle, binomial theorem,\n" +
//                        "Pascal identity and triangle.\n" +
//                        "MATHEMATICAL REASONING and INDUCTION: Rules of inference, direct proof, proof by contradiction, proof\n" +
//                        "by contrapositive, mathematical induction and second law of mathematical induction.\n" +
//                        "RECURSION: Definition, recursive algorithm, recurrence relations, solving recurrence relations.\n" +
//                        "RELATIONS: Relations and their properties, applications and representations, equivalence relations, partial ordering,\n" +
//                        "Hasse diagram.\n" +
//                        "GRAPHS: Introduction and terminology, representation, isomorphism, connectivity, Warshall‘s algorithm, Euler and\n" +
//                        "Hamilton path, shortest path.\n");
//                cs1c1.put("Textbook", "Discrete Mathematics and its Application, 7th Ed, K. Rosen, Tata McGraw Hill, 2011.");
//                cs1c1.put("Reference Book", "1) Discrete Mathematical Structure, 4th Ed, B. Kolman, R.C. Busby and S. C. Ross, PHI, 2000.\n" +
//                        "2) Discrete Mathematics, Richard Johnsonbaugh, Prentice Hall, 2007.\n" +
//                        "3) Mathematics: A Discrete Introduction, 3rd Ed., Edward R. Scheinerman, Cengage Learning, 2006.\n" +
//                        "4) Mathematical Structure for Computer Science, 6th Ed, J. Gersting, Freeman, 2006.\n");
//                cs1c1.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-4");
//
//// Add a new document with a generated ID
//                db.collection("BTECH").document("CS").collection("Semester 1").document
//                        ("Intoduction to Discrete Mathematics").set(cs1c1, SetOptions.merge());
//
//
//                // CS Semester 1 Physics details
//                Map<String, Object> cs1c2 = new HashMap<>();
//                cs1c2.put("Course Contents", "COORDINATE SYSTEM: Cartesian, cylindrical and spherical coordinates; unit vectors and their time derivatives.\n" +
//                        "REVIEW OF PARTICLE DYNAMICS: Inertial and non-inertial frames of reference, centrifugal and coriolis forces;\n" +
//                        "conservative force, work-energy theorem; centre of mass, conservation of momentum; collision in one and two\n" +
//                        "dimensions. small oscillations, free, forced and damped oscillations.\n" +
//                        "ATOMIC PHYSICS: Rutherford and Bohr's atomic model, quantum numbers, atomic spectra, energy levels.\n" +
//                        "ELEMENTARY PARTICLES: Nuclear model, protons and neutrons, nuclear force, introduction of elementary\n" +
//                        "particles.\n" +
//                        "CONCEPTUAL FOUNDATION of MODERN PHYSICS: Electromagnetic waves, blackbody radiation, Planck’s law\n" +
//                        "of radiation, photoelectric effect, wave-particle duality, Compton wavelength, de-Broglie wave, Heisenberg’s\n" +
//                        "uncertainty principle, contribution of Dirac, Pauli, Schrodinger and Born in foundation of quantum mechanics, topics\n" +
//                        "in Quantum Mechanics.\n" +
//                        "INTRODUCTION TO APPLIED PHYSICS: A non-mathematical exposure to applied physics such as:\n" +
//                        "pendulum, heat engine, transformer, optical microscope, electron microscope, scanning tunneling microscope, laser\n" +
//                        "diode, photo detector, solar cells, transistors.\n");
//                cs1c2.put("Textbook", "Concepts of Modern Physics. A.Beiser, Tata McGraw-Hill, New Delhi, 1995.\n");
//                cs1c2.put("Reference Book", "1) Quantum Physics of Atoms, Molecules, Solids, Nuclei and Particles, 2ndEd, R. Eisberg and R. Resnick , John-Wiley,\n" +
//                        "1985.\n" +
//                        "2) Quantum Mechanics: Theory and Applications 5thEd, AjoyGhatak, Macmillan, 2004.");
//                cs1c2.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-2\n" + "Total-5");
//
//
//                db.collection("BTECH").document("CS").collection("Semester 1").document
//                        ("Physics").set(cs1c2, SetOptions.merge());
//
//
//                // CS Semester 1 Introduction to Programming details
//                Map<String, Object> cs1c3 = new HashMap<>();
//                cs1c3.put("Course Contents", "INTRODUCTION TO PROGRAMMING: Programming methods, paradigms, problem solving techniques, algorithm\n" +
//                        "development, flow charts.\n" +
//                        "LINUX ENVIRONMENT: Editor, compiler, debugger.\n" +
//                        "BASICS OF PROCEDURAL PROGRAMMING: Constants, variables, expressions, operators, assignment, basic\n" +
//                        "input and output, built-in functions, program debugging.\n" +
//                        "VARIABLES AND OPERATORS: Basic data types, precedence and order of evaluation, pointers, memory allocation\n" +
//                        "of variables.\n" +
//                        "CONTROL STRUCTURES: Selection statements, iteration statements.\n" +
//                        "FUNCTIONS AND PROGRAM STRUCTURE: Return values, actual and formal parameters, parameter passing: call\n" +
//                        "by value versus call by reference, external variables, scope rules, header files, and recursion.\n" +
//                        "ARRAYS: Character arrays, one and two dimensional arrays; pointer arrays, command-line arguments.\n" +
//                        "I/O: ASCII data files, file pointers, end-of-file.\n" +
//                        "BASIC DATA STRUCTURES: Structures, defining new types, enumerations, dynamic memory allocation, dynamic\n" +
//                        "arrays, linked lists and other pointer-based structures.\n");
//                cs1c3.put("Textbook", "C How to Program, 6thEd, P Deitel and H Deitel, Prentice Hall of India, 2010.\n");
//                cs1c3.put("Reference Book", "1) C programming language, 2ndEd, Kernighan, Brian W. & Ritchie, Dennis M, New Delhi.\n" +
//                        "Prentice Hall of India, 1998.\n" +
//                        "2) A Book on C, 4thEd, Kelley, A.L. and Pohl Ira, Pearson India, 2002\n" +
//                        "3) A Structured Programming Approach Using C, 1stEd.,Forouzan, Behrouz, Course\n" +
//                        "Technology, 2012.\n" +
//                        "4) Practical C Programming, 3rdEd, Oualline, Steve, Shroff Publishers, 2000.\n" +
//                        "5) C programming: The essentials for engineering and scientists, Brooks, David R. New\n" +
//                        "York. Springer, 1999.\n");
//                cs1c2.put("Credits", "Lecture-2\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-2");
//
//                db.collection("BTECH").document("CS").collection("Semester 1").document
//                        ("Introduction to Programming").set(cs1c3, SetOptions.merge());
//
//
//
//                // CS Semester 1 Introduction to Programming Lab details
//                Map<String, Object> cs1c4 = new HashMap<>();
//                cs1c4.put("Course Contents", "Lab and take home assignments based on the course “Introduction to Programming”.\n");
//                //cs1c4.put("Textbook", "");
//                //cs1c4.put("Reference Book", "");
//                cs1c4.put("credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 1").document
//                        ("Introduction to Programming Lab").set(cs1c4, SetOptions.merge());
//
//
//                // CS Semester 1 Didital Logic Design details
//                Map<String, Object> cs1c5 = new HashMap<>();
//                cs1c5.put("Course Contents", "NUMBER SYSTEMS: Representations, signed, 1's complement, 2's complement, saturation and overflow in fixed\n" +
//                        "point arithmetic.\n" +
//                        "BOOLEAN ALGEBRA: Axioms and theorems, DeMorgan’s law, universal gate, duality, expression manipulation\n" +
//                        "using axioms and theorems.\n" +
//                        "COMBINATIONAL LOGIC: Introduction to switching algebra, canonical forms, two-level simplification, boolean\n" +
//                        "cube, logic minimization using K-map method, QuineMcCluskey tabular method, minimization for product-of-sum\n" +
//                        "form, minimization for sum-of-product form, multiplexers, demultiplexers, decoders, encoders, hazard free synthesis,\n" +
//                        "Arithmetic circuits, adders, half adder, full adder, BCD adder, ripple carry adder, carry-lookahead adder,\n" +
//                        "combinational multiplier.\n" +
//                        "SEQUENTIAL LOGIC: Simple circuits with feedback, basic latches, clocks, R-S latch, master-slave latch, J-K flip\n" +
//                        "flop, T flip-flop, D flip-flop, storage registers, shift register, ripple counter, synchronous counters, Finite State\n" +
//                        "Machine (Moore/Mealy Machines), FSM with single/multiple inputs and single/multiple outputs etc.\n" +
//                        "HARDWARE DESCRIPTION LANGUAGE: Programming and simulation, structural specification, \n" +
//                        "behavioral specification, dataflow modelling, testbench, testing using test vectors, testing using waveforms, design of\n" +
//                        "basic blocks to build larger circuits, case studies, adder, ALU, counters, shift registers, register bank, FSM design\n" +
//                        "example etc.\n");
//                cs1c5.put("Textbook", "Digital Fundamentals,10thEd, Floyd T L, Prentice Hall, 2009.\n");
//                cs1c5.put("Reference Book", "1) Digital Design-Principles and Practices, 4thEd, J F Wakerly, Prentice Hall, 2006.\n" +
//                        "2)Digital Design, Morris Mano, Prentice Hall, 2002\n" +
//                        "3) Digital Systems: Principles and Applications, Ronald J. Tocci, Neal S. Widmer, Gregory\n" +
//                        "L. Moss, Pearson Education, Limited, 2011.\n" +
//                        "4) Fundamentals of Digital Logic with Verilog Design, 2nd Ed, S. Brown and Z. Vrsaniec,\n" +
//                        "McGraw Hill, 2007\n");
//                cs1c5.put("Credits","Lecture-3\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-5" );
//
//                db.collection("BTECH").document("CS").collection("Semester 1").document
//                        ("Digital Logic Design").set(cs1c5, SetOptions.merge());
//
//
//                // CS Semester 1 Spoken and written Communication details
//                Map<String, Object> cs1c6 = new HashMap<>();
//                cs1c6.put("Course Contents", "Unit-I:\n" +
//                        "Course Instructor should make an optimal use of cinema for increasing the students’ familiarity with English. Testing\n" +
//                        "be done on the basis of the student’s comprehension of the plot and the ability of describe scenes from the film. Class\n" +
//                        "room exercise of asking students to comment on the plot or scenes of a given film – not in writing but by standing\n" +
//                        "before the entire class and speaking in English — be frequently carried out. The aim of this unit is to make the student\n" +
//                        "feel confident about her/his ability to form sentence in English for discursive communication.\n" +
//                        "Unit-II:\n" +
//                        "Course Instructor should use audio tapes, Ted Lectures, radio news broadcast or celebrated speeches, etc for exposing\n" +
//                        "the students’ to a ̳real time‘ and good spoken English. Class room tests be set to check the students’ ability to respond\n" +
//                        "to their listening experience in writing. This will help the Course Instructor to continually assess the requirements of\n" +
//                        "the students and provide corrective advise. Testing the writing skills of students will require setting several questions\n" +
//                        "of very short composition tasks, from 50 words to 150 words. The topics chosen for the composition tasks should be\n" +
//                        "selected from the topics covered in the classroom discussions or from the life on the campus.\n" +
//                        "Unit-III:\n" +
//                        "Students should be provided four to five extended samples of written English such as short stories or newspaper\n" +
//                        "editorials for them to mark their difficulties – words, idioms, sentence structures, etc. This will help the students in\n" +
//                        "improving their ability to do focused reading of serious written literature. Testing of the reading comprehension skills\n" +
//                        "be tested by giving them in advance of the test several passages for reading. The Course Instructor may select one or\n" +
//                        "more of those seen passages’ for the examination purpose.\n");
//                cs1c6.put("Textbook", "Prism: Spoken and Written Communication, Prose & Poetry published by Orient Longman, 2008.\n");
//                cs1c6.put("Reading Materials", "The Bet – Anton Chekov\n" +
//                        "Socrates and the Schoolmaster – F. L. Brayne\n" +
//                        "An Astrologer‘s Day – R. K. Narayan\n" +
//                        "The Gift of the Magi – O’ Henry\n" +
//                        "With the Photographer – Stephen Leacock\n" +
//                        "Speech on Indian Independence – Jawaharlal Nehru.\n");
//                cs1c6.put("Credits", "Lecture-2\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-2");
//
//                db.collection("BTECH").document("CS").collection("Semester 1").document
//                        ("Spoken and written Communication").set(cs1c6, SetOptions.merge());
//
//
//                // CS Semester 2 Calculus details
//                Map<String, Object> cs2c1 = new HashMap<>();
//                cs2c1.put("Course Contents", "FUNDAMENTALS: Limits, continuity, differentiability, mean value theorems, and Taylor‘s theorem; fundamental\n" +
//                        "theorem of integral calculus, definite integrals, trapezoidal and Simpson’s rule; sequences and series, tests for\n" +
//                        "convergence: absolute and conditional convergence; power series and radius of convergence.\n" +
//                        "FUNCTIONS OF SEVERAL VARIABLES: Partial derivatives, chain rule, gradient and directional derivative;\n" +
//                        "Taylor’s theorem for functions of several variables; maxima, minima and saddle points.\n" +
//                        "VECTOR CALCULUS: Gradient, divergence and curl. double, triple, line and surface integrals; theorems of Green,\n" +
//                        "Gauss, Stokes and their applications.\n" +
//                        "INTRODUCTION TO COMPLEX VARIABLES: Complex numbers and the complex plane, derivative and analytic\n" +
//                        "functions.\n" +
//                        "DIFFERENTIAL EQUATIONS: First order equations, second linear differential equations, partial differential\n" +
//                        "equations basic concepts and important examples, Laplace and Fourier transforms. \n");
//                cs2c1.put("Textbook", "Calculus and Analytical Geometry, 9th Ed, G B Thomas and R L Finney, Addison-Wesley, 1999.\n");
//                cs2c1.put("Reference Book", "1) Differential and Integral Calculus, 3th Ed, Schaum’s Outline Series, McGraw Hill, 1992.\n" +
//                        "2) Advanced Engineering Mathematics, 8th Ed, R. Kreyszig, John Wiley, 1999.\n");
//                cs2c1.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 2").document
//                        ("Calculus").set(cs2c1, SetOptions.merge());
//
//                // CS Semester 2 Data Structures details
//                Map<String, Object> cs2c2 = new HashMap<>();
//                cs2c2.put("Course Contents", "INTRODUCTION: Representation of data on a computer, data types & array and linked list representations ways of\n" +
//                        "representing programs and associated data on computers\n" +
//                        "ANALYSIS TOOLS: Notion of the running time of an algorithm, recurrences, parameters of\n" +
//                        "performance.\n" +
//                        "DICTIONARY OPERATIONS: Find, max, min, successor, predecessor (query operations); insert, delete (modify\n" +
//                        "operations)\n" +
//                        "LIST DATA: Stacks, queues, variants implementation using arrays and linked lists\n" +
//                        "SORTING: Comparison based sorting algorithms, other sorting algorithms, lower bounds for\n" +
//                        "comparison-based sorting algorithms best-case, worst-case and average-case running times;\n" +
//                        "quicksort, heap Sort, insertion sort, bubble sort etc.\n" +
//                        "ORDER STATISTICS: Maximum and minimum elements of a set, Finding median, searching for an element of a\n" +
//                        "given rank, finding the rank of a given element, ranks of a subset of elements,\n" +
//                        "maintaining rank information for a dynamic set.\n" +
//                        "TREES: heaps, Binary search trees (BST), heights of BST\n" +
//                        "BALANCED BSTs: Red Black trees, AVL Trees, 2,3,4-trees, B Trees\n" +
//                        "GRAPHS: Representation using adjacency matrices and adjacency lists, Graph searching algorithms BFS and DFS.\n");
//                cs2c2.put("Textbook", "Data Structures and Algorithms, Aho, Hopcroft and Ullman, Addison-Wesley, 1999.\n");
//                cs2c2.put("Reference Book", "Introduction to Algorithms, 3th Ed, Cormen, Lieserson and Rivest, PHI, 2011.\n");
//                cs2c2.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 2").document
//                        ("Data Structures").set(cs2c2, SetOptions.merge());
//
//
//                // CS Semester 2 Data Structures Lab details
//                Map<String, Object> cs2c3 = new HashMap<>();
//                cs2c3.put("Course Contents", "Lab and take home assignments based on the course “Data Structures”. It is essential for the instructor to use the\n" +
//                        "tutorial hours of this course to give hands on of any object oriented programming language so that students can code\n" +
//                        "the assignments given.\n");
//                //cs2c3.put("Textbook", "");
//                //cs2c3.put("Reference Book", "");
//                cs2c3.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 2").document
//                        ("Data Structures Lab").set(cs2c3, SetOptions.merge());
//
//
//                // CS Semester 2 Basic Electronic Circuits details
//                Map<String, Object> cs2c4 = new HashMap<>();
//                cs2c4.put("Course Contents", "ANALOG CIRCUIT ELEMENTS: Resistor, Capacitor, Inductor, Concepts of LLFPB, Non-linear circuit elements,\n" +
//                        "Incremental equivalent of nonlinear elements, Voltage and Current sources, Controlled sources, Active circuits,\n" +
//                        "Practical circuit elements of different types.\n" +
//                        "ANALYSIS OF LINEAR CIRCUITS: Kirchhoff‘s laws, D-C analysis of resistive circuits, Time-domain\n" +
//                        "analysis of a-c circuits ,Sinusoidal steady state analysis of a-c circuits – notions of phasors, impedance, transfer\n" +
//                        "function and frequency response, Frequency response vs transient response , Superposition theorem, Thevenin’s and\n" +
//                        "Norton’s theorems, Two-port parameters, Analysis of circuits having controlled sources.\n" +
//                        "AMPLIFIERS: Diodes, BJT, FET, Amplifier parameters, Controlled source models, Active devices as controlled\n" +
//                        "sources, Different amplifier configuration using the OPAMP, Frequency response of OPAMP and OPAMP-based\n" +
//                        "amplifiers, Power amplifiers using OPAMP and transistors.\n" +
//                        "OSCILLATORS: Amplifier with feedback, Condition of harmonic oscillation, RC oscillator circuits.\n" +
//                        "WAVEFORM GENERATORS: OPAMP as a comparator, Regenerative comparator, Timer, Relaxation\n" +
//                        "oscillator, Non-sinusoidal waveform generator using comparator.\n" +
//                        "D-C POWER SUPPLY: Half-wave and full-wave rectifiers, Shunt capacitor filter, Ripple and voltage\n" +
//                        "regulation, Voltage regulator using zener diode, Active voltage regulator.\n");
//                cs2c4.put("Textbook", "1) Electronic Principles, 7th Ed, Albert Malvino, and David Bates, Tata McGraw-Hill, 2006.\n" +
//                        "2) Microelectronic circuits, 5th Ed, A Sedra , K Smith, A N Chandorkar, Oxford University Press,2009.\n");
//                cs2c4.put("Reference Book", "1) Network Analysis, 3th Ed, Van Valkenburg, PHI, 2000.\n" +
//                        "2) Introduction to electric circuits, 8th Ed, R C. Dorf and J A Svoboda John Wiley, 2000.\n" +
//                        "3) Engineering Circuit Analysis, 6th Ed, William H.Hayt, Jack Kemmerly , Steven Durbin, Tata McGraw-Hill, 2002.\n" +
//                        "4) Electric circuit fundamentals, Sergio Franco, Oxford University Press, 1995.\n" +
//                        "5) Foundations of Analog and Digital Electronic Circuits, Anant Agarwal and Jeffrey Lang,\n" +
//                        "Morgan Kaufman, 2005.\n");
//                cs2c4.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-2\n" + "Total-5");
//
//                db.collection("BTECH").document("CS").collection("Semester 2").document
//                        ("Basic Electronic Circuits").set(cs2c4, SetOptions.merge());
//
//
//                // CS Semester 2 Computer Organization details
//                Map<String, Object> cs2c5 = new HashMap<>();
//                cs2c5.put("Course Contents", "von NEUMANN MACHINE: Functional units, stored program concept, ALU, data paths, registers, status flags;\n" +
//                        "instruction cycle.\n" +
//                        "DATA REPRESENTATION: Integer data; fixed and floating point systems; representation of non-numeric data\n" +
//                        "(characters, strings, records, and arrays).\n" +
//                        "ASSEMBLY/MACHINE LEVEL: Instruction sets and types (arithmetic, data movement, and control); instruction\n" +
//                        "formats and addressing modes, subroutine call and return mechanisms; representations of fundamental high-level\n" +
//                        "programming constructs at the assembly language\n" +
//                        "level; Heap vs. Stack vs. Static vs. Code segments.\n" +
//                        "MEMORY SYSTEM: Principles of temporal and spatial locality; cache memories (address mapping, block size,\n" +
//                        "replacement and store policy); virtual memory (page table, TLB); disk organization and data access from disk drive.\n" +
//                        "I/O COMMUNICATION: Handshaking, buffering, programmed I/O, interrupt-driven I/O, bus protocols.\n");
//                cs2c5.put("Textbook", "1) Introduction to Computing Systems: From Bits and Bytes to C and Beyond, 2th Ed, Yale Patt and Sanjay Patel, Tata\n" +
//                        "McGraw-Hill, 2001.\n" +
//                        "2) Computer Systems: A Programmer’s Perspective, 1st Ed Bryant and O’Hallaron, Pearson, 2002.\n");
//                cs2c5.put("Reference Book", "1) The Essentials of Computer Architecture and Organization, 3rd Ed, Null and Lobur, Jones & Bartlett/Viva Books,\n" +
//                        "2011.\n" +
//                        "2) Structured Computer Organization, 6th Ed, Tanenbaum and T Austin, Pearson, 2012.\n" +
//                        "3) Computer Organization and Architecture, 8th Ed, Stallings, Pearson, 2010.\n" +
//                        "4) Computer System Organization, N. Jotwani, Tata McGraw Hill, 2009.\n");
//                cs2c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-5");
//
//                db.collection("BTECH").document("CS").collection("Semester 2").document
//                        ("Computer Organization").set(cs2c5, SetOptions.merge());
//
//
//                // CS Semester 2 Introduction to Computer Science details
//                Map<String, Object> cs2c6 = new HashMap<>();
//                cs2c6.put("Course Contents", "Module – 1: Models of Computations and Complexity\n" +
//                        "Module – 2: Algorithms\n" +
//                        "Module – 3: Computer Networks\n" +
//                        "Module – 4: Cryptology and Security\n" +
//                        "Each module will have 3- 4 lectures. There is no text book specified as instructor may choose to introduce only\n" +
//                        "glimpses of each module.\n");
//                // cs2c6.put("Textbook", "");
//                // cs2c6.put("Reference Book", "");
//                cs2c6.put("Credits", "Lecture-1\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-2");
//
//                db.collection("BTECH").document("CS").collection("Semester 2").document
//                        ("Introduction to Computer Science").set(cs2c6, SetOptions.merge());
//
//
//
//                // CS Semester 3 Object Oriented Design and Programming  details
//                Map<String, Object> cs3c1 = new HashMap<>();
//                cs3c1.put("Course Contents", " INTRODUCTION: Principles of OOD; programming Paradigms; benefits of OOD&P, applications\n" +
//                        "of OOD; Classes and objects; access qualifiers; instance creation; constructors, parameterized constructors,\n" +
//                        "overloaded constructors, constructors with default arguments, copy constructors, static class members and static\n" +
//                        "objects.\n" +
//                        "FUNCTIONS an OPERATORS: Function prototyping, function components, passing parameters, inline functions,\n" +
//                        "default arguments, overloaded function; array of objects, pointers to objects, dynamic allocation operators, dynamic\n" +
//                        "objects; Operator overloading, overloading unary and binary operator, overloading the operator using friend function,\n" +
//                        "stream operator overloading, data conversion.\n" +
//                        "INHERITANCE: Defining derived classes, single inheritance, protected data with private inheritance, multiple\n" +
//                        "inheritance, multi level inheritance, hierarchical inheritance, hybrid inheritance, multipath inheritance, constructors in\n" +
//                        "derived and base class, abstract classes, virtual function and dynamic polymorphism, virtual destructor.\n" +
//                        "EXCEPTION HANDLING: Principle of exception handling, exception handling mechanism, multiple catch, nested\n" +
//                        "try, re/throwing the exception.\n" +
//                        "OBJECT ORIENTED DESIGN: Requirements modeling, business modeling, component based development;\n" +
//                        "Rational Unified Process (RUP), process overview, phases and iterations, static structure of the process, core\n" +
//                        "workflows; UML history, building blocks of UML, structural modeling, behavioral modeling; Use Case Diagrams,\n" +
//                        "Modeling Ordered Interactions: Sequence Diagrams; case studies.\n");
//                cs3c1.put("Textbook", "1) Introduction to object-oriented programming, B. Timothy, Pearson, 2001.\n" +
//                        "2) Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development,\n" +
//                        "C. Larman , Prentice Hall, 2004.\n");
//                cs3c1.put("Reference Book", "1) Object Oriented Design and Patterns, C. Horstmann, John Wiley & Sons, 2005.\n" +
//                        "2) Unified Modeling Language User Guide, G. Booch, J. Rumbaugh, I. Jacobson, Pearson Education, 2001.\n" +
//                        "3) Object-Oriented Systems Analysis and Design using UML, Bennett, McRobb, Farmer, McGraw-Hill, 2002\n");
//                cs3c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 3").document
//                        ("Object Oriented Design and Programming").set(cs3c1, SetOptions.merge());
//
//                // CS Semester 3 Object Oriented Design and Programming Lab details
//                Map<String, Object> cs3c2 = new HashMap<>();
//                cs3c2.put("Course Contents", " Lab and take home assignments based on the course “OOD & P”. Emphasis on following topics:\n" +
//                        "\uF0A7 Eclipse (or NetBeans) IDE introduction\n" +
//                        "\uF0A7 Compiling & running programs on IDE\n" +
//                        "\uF0A7 Object oriented coding conventions\n" +
//                        "\uF0A7 Simple example of object-oriented design and message passing\n" +
//                        "\uF0A7 Problems on object based iteration\n" +
//                        "\uF0A7 Problems on object based arrays, matrices, and strings\n" +
//                        "\uF0A7 Design oriented problems on object polymorphism\n" +
//                        "\uF0A7 Design oriented problems on object inheritance & overriding\n" +
//                        "\uF0A7 Object-oriented designing of advanced data structures (linked list, trees, graphs, tables)\n" +
//                        "\uF0A7 Problems on object based linked lists\n" +
//                        "\uF0A7 Problems on object based trees\n" +
//                        "\uF0A7 Problems on object based graphs\n" +
//                        "\uF0A7 Mini Projects");
//                // cs3c2.put("Textbook", "");
//                //cs3c2.put("Reference Book", "");
//                cs3c2.put("credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 3").document
//                        ("Object Oriented Design and Programming Lab").set(cs3c2, SetOptions.merge());
//
//
//                // CS Semester 3 Operating Systems  details
//                Map<String, Object> cs3c3 = new HashMap<>();
//                cs3c3.put("Course Contents", "Introduction: overview and history, multiprogramming, functions of an OS, device drivers, I/O interrupts, and system\n" +
//                        "call interface.\n" +
//                        "Process management: the process abstraction, process states, implementing processes (PCB), CPU scheduling\n" +
//                        "algorithms, real-time scheduling, inter-process communication, threads.\n" +
//                        "Resource allocation: classical synchronization problems; synchronization primitives; semaphores; monitors;\n" +
//                        "Deadlocks, deadlock avoidance.\n" +
//                        "Virtual memory management: segmentation, demand paging, hardware support, page fault handling; page\n" +
//                        "replacement algorithms; shared memory.\n" +
//                        "Files systems: logical disks, file organization, buffer cache, file descriptor, directory structure, blocks and fragments,\n" +
//                        "directory tree, inodes, implementation of file system, file protection and access control.\n");
//                cs3c3.put("Textbook", "William Stallings, Operating Systems: internals and design principles, 6th edition PHI.\n");
//                cs3c3.put("Reference Book", "Silberschatz, Abraham, Galvin, Peter B. & Gagne, Greg: Operating system concepts, 8th ed.. New Delhi. Wiley India,\n" +
//                        "2009.\n" +
//                        "Andrew Tanenbaum, Modern Operating Systems.\n" +
//                        "Uresh Vahalia, UNIX Internals: The New Frontiers, Pearson Education Asia, 2002.\n");
//                cs3c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-5");
//
//                db.collection("BTECH").document("CS").collection("Semester 3").document
//                        ("Operating Systems").set(cs3c3, SetOptions.merge());
//
//
//                // CS Semester 3 Systems and Signal Theory details
//                Map<String, Object> cs3c4 = new HashMap<>();
//                cs3c4.put("Course Contents", "The course first builds up fundamentals and introduction of signals and systems ranging from their types, properties\n" +
//                        "and different examples. The course then discusses extremely useful class of systems, viz., linear time-invariant (LTI)\n" +
//                        "systems and their representation with the help of convolution sum (which can used to model many physical\n" +
//                        "processes). Fourier analysis ranging from Fourier series, Fourier transform, time and frequency characterization is\n" +
//                        "discussed in a greater depth followed by study on Shannon’s sampling theory. The course then shifts to Z-transform\n" +
//                        "and Laplace transform with detailed discussion on properties and their applications. The course also discusses in detail\n" +
//                        "design of digital resonators and their applications in addition to discussion on application of signals and systems\n" +
//                        "methods to control systems and communication systems. \n");
//                cs3c4.put("Textbook", "1. A. V. Oppenheim, A. S. Wilsky and S. H. Nawab, “Signals and Systems,” 2\n" +
//                        "nd edition, Prentice-Hall of India,\n" +
//                        "1999 .\n" +
//                        "2. B. P. Lathi, “Linear Systems and Signals,” Berkeley-Cambridge Press, 1992.\n" +
//                        "3. Simon Haykin, “Signals and Systems,”\n");
//                cs3c4.put("Reference Book", "1. A.V. Oppenheim and R.W. Schafer, Discrete-Time Signal Processing. Prentice-Hall, Englewood Cliffs, NJ,\n" +
//                        "1989.\n" +
//                        "2. G. Strang, Linear Algebra and its Applications. Harcourt Brace Jovanovich, Publishers, San Diego, 1988.\n" +
//                        "3. R. N. Bacewell, “The Fourier Transform and Its Applications,” 2nd edition, McGraw-Hill, New York, 1986.\n");
//                cs3c4.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 3").document
//                        ("Systems and Signal Theory").set(cs3c4, SetOptions.merge());
//
//
//                // CS Semester 3 Probability and Statistics  details
//                Map<String, Object> cs3c5 = new HashMap<>();
//                cs3c5.put("Course Contents", "INTRODUCTION: Classical, relative frequency and axiomatic definitions of probability, addition rule and conditional\n" +
//                        "probability, multiplication rule, total probability, Bayes’ theorem and independence.RANDOM VARIABLES:\n" +
//                        "Discrete, continuous and mixed random variables, probability mass, probability density and cumulative distribution\n" +
//                        "functions, mathematical expectation, moments, probability and moment generating function, median and quantiles,\n" +
//                        "Markov inequality, Chebyshev’s inequality.SPECIAL DISTRIBUTIONS: Discrete uniform, binomial, geometric,\n" +
//                        "negative binomial, hypergeometric, Poisson, continuous uniform, exponential, gamma, beta, normal, lognormal,\n" +
//                        "inverse Gaussian, Cauchy, double exponential distributions, reliability and hazard rate, reliability of series and parallel\n" +
//                        "systems.JOINT DISTRIBUTIONS: Joint, marginal and conditional distributions, product moments, correlation and\n" +
//                        "regression, independence of random variables, bivariate normal distribution.TRANSFORMATIONS: functions of\n" +
//                        "random vectors, distributions of order statistics, distributions of sums of random variables.SAMPLING\n" +
//                        "DISTRIBUTIONS: Mean, median, variance, standard deviation, The Central Limit Theorem, distributions of the\n" +
//                        "sample mean and the sample variance for a normal population, Chi-Square, t and F distributions. ESTIMATION:\n" +
//                        "Unbiasedness, consistency, the method of moments and the method of maximum likelihood estimation, confidence\n" +
//                        "intervals for parameters in one sample and two sample problems of normal populations, confidence intervals for\n" +
//                        "proportions.TESTING OF HYPOTHESES: Null and alternative hypotheses, the critical and acceptance regions, two\n" +
//                        "types of error, power of the test, the most powerful test and Neyman-Pearson Fundamental Lemma, tests for one\n" +
//                        "sample and two sample problems for normal populations, tests for proportions, Chi square goodness of fit test and its\n" +
//                        "applications.\n");
//                cs3c5.put("Textbook", "Introduction to Probability and Statistics for Engineers and Scientists, S. M. Ross, Academic Press, 2009. \n");
//                cs3c5.put("Reference Book", "1) Introduction to Probability and Statistics, J.S. Milton & J. C. Arnold, Cengage Learning, 2008\n" +
//                        "2) Introduction to Probability Theory and Statistical Inference, H.J. Larson, Wiley, 1982.\n" +
//                        "3) A First Course in Probability, S.M. Ross, Prentice Hall, 2001.\n");
//                cs3c5.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 3").document
//                        ("Probability and Statistics ").set(cs3c5, SetOptions.merge());
//
//
//                // CS Semester 3 Economics details
//                Map<String, Object> cs3c6 = new HashMap<>();
//                cs3c6.put("Course Contents", "The Problems of Economic Organisation; Demand and Supply; Price Determination; Elasticity of Demand and\n" +
//                        "Supply; Theory of Production; Production function; Law of diminishing returns; Analysis of Cost; Fixed and variable\n" +
//                        "costs; Marginal cost; Market Structure and Various Types of Markets; Perfectly Competitive Market; Monopolistic\n" +
//                        "Markets; Aggregate Demand and Aggregate Supply; Determination Of National Income and criticisms; Consumption,\n" +
//                        "Saving and Investment; Business Cycle and remedies; International Trade; Balance of Payment; Case for and against\n" +
//                        "free trade; Economics of banking; Interest rates and demand for money; Role of Central Bank; Inflation:\n" +
//                        "measurement, causes and index numbers.\n");
//                cs3c6.put("Textbook", "1) Economics, P. Samuelson & Nordhaus, Tata-McGraw Hill.\n" +
//                        "2) Indian Economy, Ruddar Datt & Sundaram, S. Chand & Co.\n");
//                //cs3c6.put("Reference Book", "");
//                cs3c6.put("Credits","Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3" );
//
//                db.collection("BTECH").document("CS").collection("Semester 3").document
//                        ("Economics").set(cs3c6, SetOptions.merge());
//
//
//
//
//                // CS Semester 4 Database Management System details
//                Map<String, Object> cs4c1 = new HashMap<>();
//                cs4c1.put("Course Contents", "INTRODUCTION AND CONCEPTUAL MODELING: Databases and database users; database system concepts and\n" +
//                        "architecture; data modeling using the entity relationship (ER) model; enhanced entity relationship.\n" +
//                        "DATA STORAGE AND INDEXING: Introduction, record storage, and primary file organization index structures for\n" +
//                        "files; single level indexing; multilevel indexing.\n" +
//                        "RELATIONAL MODEL: The relational data model; relational database constraints; relational algebra; relational\n" +
//                        "calculus; relational database design by ER and EER; relational mapping; SQL; the relational database standard;\n" +
//                        "examples of relational database management systems; Oracle.\n" +
//                        "DATABASE DESIGN THEORY AND METHODOLOGY: Functional dependencies and normalization for relational\n" +
//                        "databases, relational database design algorithms and further dependencies.\n" +
//                        "SYSTEM IMPLEMENTATION TECHNIQUES: Query processing and optimization, transaction processing concepts,\n" +
//                        "concurrency control techniques, database recovery techniques .\n" +
//                        "OBJECT AND OBJECT RELATIONAL DATABASES: Object database concepts, the ODMG standard for object\n" +
//                        "databases, object relational systems and SQL.\n" +
//                        "EMERGING APPLICATIONS: Distributed databases and client/server models, XML Database (DTD, XML Schema),\n" +
//                        "Query for XML Database, NoSQL.\n");
//                cs4c1.put("Textbook", "Fundamentals of Database Systems, R. Elmasri, S. B. Navathe, Prentice Hall, New Delhi, 2007.\n");
//                cs4c1.put("Reference Book", "1) Database System Concepts, A. Silberschatz, H. F. Korth, S. Sudharshan,Tata McGraw Hill, New Delhi, 2005.\n" +
//                        "2) Introduction to Database Systems, C. J. Date, Prentice Hall, New Delhi, 2004.\n");
//                cs4c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 4").document
//                        ("Database Management System").set(cs4c1, SetOptions.merge());
//
//                // CS Semester 4 Database Management System Lab  details
//                Map<String, Object> cs4c2 = new HashMap<>();
//                cs4c2.put("Course Contents", "Lab and take home assignments based on the course “DBMS”. Emphasis on following topics:\n" +
//                        "ER MODELING TOOL (ERWin): Introduction to ERWin; Adding Entity types & relations; Forward generation.\n" +
//                        "ABSTRACT QUERY LANGUAGE INTERPRETER (JCup & JFlex): Relational Algebra (syntax, RA interpreter);\n" +
//                        "Domain Relational Calculus (syntax, DRC interpreter); Datalog (syntax, Datalog interpreter).\n" +
//                        "RELATIONAL DATABASE MANAGEMENT SYSTEM (Oracle): SQL* Plus Utility; SQL* Loader Utility;\n" +
//                        "Programming with Oracle using JDBC API.\n" +
//                        "RELATIONAL DATABASE MANAGEMENT SYSTEM (MySQL): MySQL Utility; Bulk loading of data; MySQL\n" +
//                        "and PHP programming; Making an online Address Book.\n" +
//                        "DATABASE DESIGN TOOLKIT (DBD): Coding Relational Schemas & Functional Dependencies; Invoking\n" +
//                        "SWI-Prolog Interpreter; DBD system predicates (xplus, finfplus, fplus, implies, equiv, superkey, candkey, mincover.\n" +
//                        "OBJECT-ORIENTED DATABASE MANAGEMENT SYSTEM (db4o): db4o Installation & Introduction; Simple\n" +
//                        "database creation exercise; Database updates & deletes; Database Querying (queryByExample, Native Queries, SODA\n" +
//                        "Queries); Company database application exercise; Web application exercise (client-server configuration).\n" +
//                        "XML DATABASE: XML basics; Creating a company database in XML; XML Editor (EditiX); XPath; XQuery;\n" +
//                        "FLWOR expressions; XML Schema\n");
//                //cs4c2.put("Textbook", "");
//                cs4c2.put("Reference", "Fundamentals of Database Systems: Laboratory Manual, R. Sunderraman\n" +
//                        "(http://tinman.cs.gsu.edu/~raj/elna-lab-2010/lab-manual.pdf).\n");
//                cs4c2.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 4").document
//                        ("Database Management System Lab ").set(cs4c2, SetOptions.merge());
//
//
//                // CS Semester 4 Computer Networks details
//                Map<String, Object> cs4c3 = new HashMap<>();
//                cs4c3.put("Course Contents", "Introduction: Overview of an internet, internet as a service, internet architecture, circuit switching, packet switching,\n" +
//                        "network performance metrics (delay, packet loss and throughput), layered approach (TCP/IP and OSI models)\n" +
//                        "Link layer: multiple access protocols (channel partitioning protocols, random access protocols and CSMA protocols),\n" +
//                        "Ethernet – IEEE 802.3, Token ring – IEEE 802.5, WiFi – IEEE 802.11, reliable link layer protocols (stop and wait,\n" +
//                        "sliding window protocols), switches and bridges.\n" +
//                        "Network layer: IP addressing: IPv4, IPv6 and ICMP header formats; intradomain routing: distance vector and link\n" +
//                        "state routing protocols; interdomain routing: BGP; routing for multicasting and broadcasting.\n" +
//                        "Transport layer: principles of reliable data transfer; connection oriented transport: TCP connection establishment,\n" +
//                        "TCP timeout estimation, TCP RTT estimation, TCP congestion control; connectionless transport: UDP.\n" +
//                        "Application layer: network applications, hypertext transfer protocol, domain name system, simple mail transfer\n" +
//                        "protocol, socket interface, client-server programming.\n");
//                cs4c3.put("Textbook", "1. Computer Networks: A Systems Approach (Fifth edition) by L. L. Peterson and B. S. Davie, publisher:\n" +
//                        "Morgan Kaufmann\n" +
//                        "2. Computer Networking: A Top-Down Approach (Fifth edition) by J. F. Kurose and K. W. Ross, publisher:\n" +
//                        "Pearson .\n");
//                cs4c3.put("Reference Book", "TCP/IP Illustrated Volume 1: The Protocols, Second edition, K. R. Fall and W. Richard Stevens, publisher: Pearson.\n");
//                cs4c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 4").document
//                        ("Computer Networks").set(cs4c3, SetOptions.merge());
//
//
//                // CS Semester 4 Computer Networks LAB  details
//                Map<String, Object> cs4c4 = new HashMap<>();
//                cs4c4.put("Course Contents", "Lab assignments based on the course “Computer Networks”. \n");
//                //cs4c4.put("Textbook", "");
//                //cs4c4.put("Reference Book", "");
//                cs4c4.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 4").document
//                        ("Computer Networks LAB ").set(cs4c4, SetOptions.merge());
//
//
//                // CS Semester 4 Design and Analysis of Algorithms details
//                Map<String, Object> cs4c5 = new HashMap<>();
//                cs4c5.put("Course Contents", "This course intends to provide a rigorous introduction to fundamental techniques in the design and analysis of\n" +
//                        "algorithms. The course can be divided into five parts namely (1) Foundations, (2) Sorting and Order Statistics, (3)\n" +
//                        "Advanced Design and Analysis Techniques, (4) Graph Algorithms and (5) Special Topics. In the Foundations part, we\n" +
//                        "will overview asymptotic notation, divide and conquer techniques, solving recurrences, probabilistic analysis and\n" +
//                        "randomized algorithms. In the Sorting and Order Statistics part, we will cover heapsort, quicksort, sorting in linear\n" +
//                        "time and median order statistics. In the Advanced Design and Analysis Techniques part, we will cover dynamic\n" +
//                        "programming, greedy algorithms and amortized analysis. In the Graph Algorithms part, we will cover depth first\n" +
//                        "search, breadth-first search, bi-connectivity and strong connectivity, topological sort, minimum spanning trees,\n" +
//                        "shortest paths and maximum flow. If time permits, we will cover Rabin-Karp and Knuth-Morris-Pratt’s string\n" +
//                        "matching algorithms as a part of Special Topics. This course is open to third and final year B.Tech students.\n" +
//                        "Topics\n" +
//                        "Foundations: Asymptotic notation, Divide and Conquer Techniques, Solving Recurrences, Probabilistic Analysis and\n" +
//                        "Randomized Algorithms\n" +
//                        "Sorting and Order Statistics: Heapsort, Quicksort, Sorting in Linear Time, Median Order Statistics.\n" +
//                        "Advanced Design and Analysis Techniques: Dynamic Programming, Greedy Algorithms and Amortized Analysis\n" +
//                        "Graph Algorithms: Depth First search, Breadth First Search, Bi-connectivity and Strong Connectivity, Topological\n" +
//                        "Sort, Minimum Spanning Trees, Shortest Paths and Maximum Flow\n" +
//                        "String Matching: Rabin-Karp and Knuth-Morris-Pratt’s string matching algorithms\n");
//                cs4c5.put("Textbook", " Introduction to Algorithms by Cormen, Lieserson, Rivest and Stein, 2nd or 3rd edition, Eastern Economy\n" +
//                        "Edition,, MIT Press.");
//                //cs4c5.put("Reference Book", "");
//                cs4c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 4").document
//                        ("Design and Analysis of Algorithms ").set(cs4c5, SetOptions.merge());
//
//
//                // CS Semester 4 Science, Technology, Society details
//                Map<String, Object> cs4c6 = new HashMap<>();
//                cs4c6.put("Course Contents", "Module 1:\n" +
//                        "\uF0A7 Introduction to STS as a field of study and research in the twentieth century\n" +
//                        "\uF0A7 Philosophical, Historical and Sociological Approaches to Science and Technology and Society\n" +
//                        "\uF0A7 The growth and identity of Modern Science and Technology in India\n" +
//                        "Module 2: Science Communication- Institutions, ideologies, practices\n" +
//                        "\uF0A7 The diversity of science communication in colonial India\n" +
//                        "\uF0A7 Science communication and the Nehruvian Agenda\n" +
//                        "\uF0A7 The ideology and image of developmental science\n" +
//                        "\uF0A7 The agenda of People’s Science\n" +
//                        "\uF0A7 Liberalization and the commoditization of science and technology.\n");
//                cs4c6.put("Textbook", "1) Science, Technology and Medicine in Colonial India – David Arnold (Cambridge,2004)\n" +
//                        "2) Western Science in Modern India, Metropolitan Methods, Colonial Practices – Pratik Chakrabarti, (Permanent\n" +
//                        "Black, 2004)\n");
//                cs4c6.put("Reference Book", "A Concise History of Science in India – D. M. Bose, S. N. Sen, and B.V. Subarayappa (Universities Press, 2009)\n");
//                cs4c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 4").document
//                        ("Science, Technology, Society").set(cs4c6, SetOptions.merge());
//
//
//                // CS Semester 4 Technical Writing details
//                Map<String, Object> cs4c7 = new HashMap<>();
//                cs4c7.put("Course Contents", "Structure of sentences, paragraphs, and documents. using stress for emphasis, and sequencing topics to create forward\n" +
//                        "flow, writing for the reader; Formats of technical documents; the experimental report; the technical report, the\n" +
//                        "proposal; workshop on published documents; Discussion and workshop on term paper proposals; Graphics; emphasis\n" +
//                        "without distortion; visual illusions; a minimalist approach to data representation; univariate and multivariate displays;\n" +
//                        "Discussion and workshop on term papers; elements of oral presentations; oral presentations.\n");
//                cs4c7.put("Textbook", "1) The Elements of Style, W. Strunk, E B White, New York: Macmillan, 1972.\n" +
//                        "2) The Mayfield Handbook of Technical and Scientific Writing, L. Perelman, Mayfield Publishing Company, 1998.\n" +
//                        "3) The Science of Scientific Writing, G. D. Gopen, J. A. Swan, American Scientist, 78(6):550-558, Nov-Dec 1990.\n");
//                //cs4c7.put("Reference Book", "");
//                cs4c7.put("Credits", "Lecture-1\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 4").document
//                        ("Technical Writing").set(cs4c7, SetOptions.merge());
//
//
//
//
//                // CS Semester 5 Principles of Programming Language details
//                Map<String, Object> cs5c1 = new HashMap<>();
//                cs5c1.put("Course Contents", " Introduces theoretical concepts in programming languages and familiarizes students with\n" +
//                        "different paradigms including functional, object-oriented and logic programming paradigms. This course emphasizes\n" +
//                        "the design and implementation of programming languages, including data representation and types, functions,\n" +
//                        "sequence control, environments, block structure, subroutines, storage management.\n");
//                cs5c1.put("Course Goals", "\uF0B7 Be able to compare and evaluate different programming languages and implement different programming\n" +
//                        "constructs and features (e.g. variables, loops, procedures, dynamic memory);\n" +
//                        "\uF0B7 Be able to\n" +
//                        "o Formally specify the syntax and semantics of programming languages.\n" +
//                        "o Write a lexical analyzer, parser and a translator to convert from one language to another;\n" +
//                        "o Describe the semantics of and implement an interpreter and compiler for a simple programming\n" +
//                        "language;\n" +
//                        "o Understand the major programming paradigms and be able to use at least one language from each\n" +
//                        "paradigm. \n");
//                cs5c1.put("Textbook", "Kenneth C. Louden & Kenneth A. Lambert, Programming Languages, Principles and Practice, 3rd\n" +
//                        "Edition, Cengage Learning, 2012.\n");
//                cs5c1.put("Reference Book", " Alfred V. Aho, Monica S. Lam, Ravi Sethi and Jeffrey D. Ullman, Compilers: Principles, Techniques,\n" +
//                        "and Tools, 2\n" +
//                        "nd Edition, Pearson Education, 2006\n" +
//                        "Michael L. Scott, Programming Language Pragmatics, 3\n" +
//                        "rd Edition, Morgan Kaufmann Publishers, 2009.\n");
//                cs5c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 5").document
//                        ("Principles of Programming Language").set(cs5c1, SetOptions.merge());
//
//                // CS Semester 5 Formal Languages and Automata Theory details
//                Map<String, Object> cs5c2 = new HashMap<>();
//                cs5c2.put("Course Contents", "This course introduces Introduce students to (i) the various types of regular languages, their\n" +
//                        "equivalences to finite automata, various techniques in analyzing the closure and algorithmic properties of regular\n" +
//                        "languages; (ii) context sensitive languages, their grammars; and (iii) Turing machines and Undecdability.\n");
//                cs5c2.put("Course Goals", " Introduce students to (i) the various types of regular languages, their equivalences to finite\n" +
//                        "automata; (ii) context sensitive languages, their grammars; and (iii) Turing machines and Undecdability.\n");
//                cs5c2.put("Topics", "This course introduces Regular Languages: various types of finite\n" +
//                        "automata and their equivalences thereof, minimization of finite automata, Myhill-Nerode theorem, regular\n" +
//                        "expressions, regular grammars, closure properties of regular languages, pumping lemma, algorithmic properties of\n" +
//                        "regular languages;\n" +
//                        "Context-free languages: context-free grammars, derivation trees, ambiguous grammars, Chomsky and Greibach\n" +
//                        "normal form, nondeterministic and deterministic pushdown automata, pumping lemma and Ogden’s lemma, closure\n" +
//                        "and algorithmic properties of context-free languages, Top-down and Bottom-up parsing;\n" +
//                        "Context sensitive languages: context sensitive grammars, linear bounded automata; Turing machines: recursively\n" +
//                        "enumerable languages, unrestricted grammars, variants of Turing machines and equivalence thereof. Undecidability.\n");
//                cs5c2.put("Textbook", "J. E. Hopcroft, R. Motwani and J. D. Ullman, Introduction to Automata Theory, Languages and Computation, Pearson,\n" +
//                        "2001. \n");
//                cs5c2.put("Reference Book", " H. R. Lewis and C. H. Papadimitriou, Elements of the Theory of Computation, Prentice Hall,\n" +
//                        "1997/Pearson 1998. \n");
//                cs5c2.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 5").document
//                        ("Formal Languages and Automata Theory").set(cs5c2, SetOptions.merge());
//
//
//                // CS Semester 5 Software Engineering details
//                Map<String, Object> cs5c3 = new HashMap<>();
//                cs5c3.put("Course Contents", "INTRODUCTION: The evolving role of software; software characteristics; software process - software process\n" +
//                        "models; linear sequential model; prototyping model; The RAD model; evolutionary software process models; The\n" +
//                        "incremental model; The spiral model.\n" +
//                        "SYSTEM ENGINEERING: Requirements analysis and negotiation; Requirements validation; Requirements\n" +
//                        "management.\n" +
//                        "ANALYSIS MODELING: Data modeling; data objects, attributes and relationships; cardinality and modality;\n" +
//                        "entity-relationship diagram; data flow diagrams; data dictionary.\n" +
//                        "DESIGN CONCEPTS AND PRINCIPLES: Software architecture; control hierarchy; structural partitioning; functional\n" +
//                        "Independence; cohesion, coupling; design documentation; architectural design; transform centered architecture;\n" +
//                        "transaction centered architecture; user Interface design models, user interface design process.\n" +
//                        "TESTING TECHNIQUES: Software testing fundamentals; test case design; White box testing; basis path testing;\n" +
//                        "control structure testing; Black box testing, testing for specialized environments, testing strategies; verification and\n" +
//                        "validation - unit testing, integration testing, validation testing, system testing, debugging.\n" +
//                        "SOFTWARE QUALITY ASSURANCE: Quality concepts; cost of quality, Software Quality Assurance (SQA) Group -\n" +
//                        "roles and responsibilities, formal technical reviews, quality standards.\n");
//                cs5c3.put("Textbook", "Software Engineering – A Practitioner’s Approach, R. S. Pressman, McGraw Hill International Edition, Singapore,\n" +
//                        "2006.\n");
//                cs5c3.put("Reference Book", "1) Software Engineering, I. Sommerville, Pearson Education, New Delhi, 2001.\n" +
//                        "2) An Integrated Approach to Software Engineering, P. Jalote, Narosa Publishers, New Delhi, 2005.\n");
//                cs5c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 5").document
//                        ("Software Engineering ").set(cs5c3, SetOptions.merge());
//
//
//                // CS Semester 5 Software Engineering LAB details
//                Map<String, Object> cs5c4 = new HashMap<>();
//                cs5c4.put("Course Contents", "Lab assignments based on the course “Software Engineering”.\n");
//                //cs5c4.put("Textbook", "");
//                //cs5c4.put("Reference Book", "");
//                cs5c4.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 5").document
//                        ("Software Engineering LAB").set(cs5c4, SetOptions.merge());
//
//
//                // CS Semester 5 Numerical Linear Algebra details
//                Map<String, Object> cs5c5 = new HashMap<>();
//                cs5c5.put("Course Contents", "Vector sub-spaces, dimension, Linear transformations and their representation by matrices, rank of a matrix\n" +
//                        "Triangular form, Matrix norms, Conditioning of linear systems, Direct methods (Gauss, Cholesky, Householder),\n" +
//                        "Iterative methods (Jacobi, Gauss-Seidel,Relaxation) for solving linear systems, Computing of eigen values &\n" +
//                        "eigen-vectors (Jacobi, Givens-Householder, Q-R, Inverse methods), Conjugate gradient method & its preconditioning.\n");
//                cs5c5.put("Textbook", "Applied Numerical Linear Algebra, James W. Demmel, SIAM, 1997.\n" +
//                        "Numerical Linear Algebra, Lloyd V. Trefethen, David Bau, SIAM, 1997.\n");
//                cs5c5.put("Reference Book", "1. S Kumaresan, Linear Algebra, A Geometric approach, Prentice Hall of India, 2000.\n");
//                cs5c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 5").document
//                        ("Numerical Linear Algebra").set(cs5c5, SetOptions.merge());
//
//
//                // CS Semester 5 Environmental Sciences details
//                Map<String, Object> cs5c6 = new HashMap<>();
//                cs5c6.put("Course Contents", "TBD [Taking clue from the curriculum of DA-IICT, Gandhinagar].");
//                //cs5c6.put("Textbook", "");
//                //cs5c6.put("Reference Book", "");
//                cs5c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 5").document
//                        ("Environmental Sciences").set(cs5c6, SetOptions.merge());
//
//
//
//                // CS Semester 5 Sciences Elective – 1 details
//                Map<String, Object> cs5c7 = new HashMap<>();
//                //cs5c7.put("Course Contents", "");
//                //cs5c7.put("Textbook", "");
//                //cs5c7.put("Reference Book", "");
//                cs5c7.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 5").document
//                        ("Sciences Elective – 1 ").set(cs5c7, SetOptions.merge());
//
//
//
//
//                // CS Semester 6 Compiler Design details
//                Map<String, Object> cs6c1 = new HashMap<>();
//                cs6c1.put("Course Description", " This course introduces concepts relevant to practical compiler construction. Topics include\n" +
//                        "formal programming language translation, program syntax, semantics, Finite state machines, regular expressions,\n" +
//                        "context-free parsing techniques such as LL(k) and LR(k), code generation, simple optimizations.\n");
//                cs6c1.put("List of Topics", "(Topics generally conform to the order in the primary required text): Lexical analysis (scanning, scanner\n" +
//                        "generation), Parsing (recursive descent, LL(1), LR(1)), Context-sensitive analysis (\n" +
//                        "ad hoc techniques and attribute grammars or syntax-directed translation), Intermediate representations, The procedure\n" +
//                        "abstraction and how to implement it, Heap management, Simple code generation, Instruction selection (better code\n" +
//                        "generation), Register allocation (better code generation), Code improvement techniques (data-ow analysis,\n" +
//                        "dependence analysis, simple transformations).\n");
//                cs6c1.put("Textbook", " A. Aho, R. Sethi, J. Ullman, M. Lam, Compilers: Principles, Techniques and Tools\n" +
//                        "Addison-Wesley Publishing Company, New York, New York, 2006\n");
//                // cs6c1.put("Reference Book", "");
//                cs6c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 6").document
//                        ("Compiler Design").set(cs6c1, SetOptions.merge());
//
//
//
//                // CS Semester 6 Compiler Design LAB details
//                Map<String, Object> cs6c2 = new HashMap<>();
//                cs6c2.put("Course Contents", "Lab assignments based on the course “Compiler Design”. ");
//                //cs6c2.put("Textbook", "");
//                //cs6c2.put("Reference Book", "");
//                cs6c2.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 6").document
//                        ("Compiler Design LAB").set(cs6c2, SetOptions.merge());
//
//
//                // CS Semester 6 Introduction to Artificial Intelligence details
//                Map<String, Object> cs6c3 = new HashMap<>();
//                cs5c6.put("Course Contents", "INTRODUCTION: The state of art; intelligent agents; structure; environment.\n" +
//                        "SEARCH STRATEGIES: Breadth-first search; uniform cost search; depth-first search; depth-limited search; iterative,\n" +
//                        "deepening search; bi-directional search; heuristic search techniques; comparing search strategies.\n" +
//                        "KNOWLEDGE AND REASONING: Prepositional logic; predicate logic; rules; forward and backward chaining;\n" +
//                        "strong and weak slot fillers.\n" +
//                        "PLANNING: Overview, example domain, components; goal stack planning; non-linear planning; hierarchical\n" +
//                        "planning; reactive systems; uncertainty: non-monotonic reasoning; logics; implementation; probability and Bayes\n" +
//                        "theorem; certainty factors; Bayesian networks; Dempster Shafer theory.\n" +
//                        "INTRODUCTION TO EXPERT SYSTEMS: What is an Expert System; advantages of Expert System; general\n" +
//                        "concepts of Expert system, characteristics of Expert System; Expert System application and domain.\n" +
//                        "THE REPRESENTATION OF KNOWLEDGE: The meaning of knowledge, production, semantic nets, schemata,\n" +
//                        "frames; prepositional logic; The first Order Predicate Logic; The Universal Quantifier; The Existential Quantifier.\n" +
//                        "DESIGN OF EXPERT SYSTEMS: Introduction, rule-based system architecture, nonproduction system architecture,\n" +
//                        "dealing with uncertainty; knowledge acquisition and validation; knowledge system building tools; selecting the\n" +
//                        "appropriate problem; stages in the development of Expert system; errors in development stages; software engineering\n" +
//                        "and expert systems.\n");
//                cs6c3.put("Textbook", "1) Artificial Intelligence – A Modern Approach, S. Russell, P. Norvig, Pearson Education, New Delhi, 2002.\n" +
//                        "2) Artificial Intelligence, E. Rich, K. Knight, Tata McGraw Hill, New Delhi, 1991.\n");
//                cs6c3.put("Reference Book", "1) Artificial Intelligence, P. H. Winston, Pearson Education, New Delhi, 1992.\n" +
//                        "2) Introduction to AI and Expert Systems, D. W Patterson, Prentice Hall, New Delhi, 1990.\n");
//                cs6c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 6").document
//                        ("Introduction to Artificial Intelligence").set(cs6c3, SetOptions.merge());
//
//
//                // CS Semester 6 Computer Architecture details
//                Map<String, Object> cs6c4 = new HashMap<>();
//                cs6c4.put("Course Contents", "Introduction, Logic Design Convention, Building a Data path, An overview of Pipelining, Pipelined Data path and\n" +
//                        "Control, Data dependency and hazard, Control hazard and Structural Hazard, Exceptions\n" +
//                        "Defining Computer Architecture, Trends in technology, Measuring, reporting and summarizing performance\n" +
//                        "Instruction Level Parallelism (ILP) Concepts and Challenges, Basic compiler techniques for exposing ILP, Reducing\n" +
//                        "Branch costs with advanced branch prediction techniques, Overcoming Data hazards with dynamic scheduling,\n" +
//                        "Dynamic scheduling: examples, Hardware based speculation, Exploiting ILP using multiple Issue and static\n" +
//                        "scheduling (Super-scalar), ILP using dynamic scheduling, multiple issue and speculation, Limitations of ILP\n" +
//                        "Data-level parallelism in Vector, SIMD and GPU architecture, Introduction to Vector, SIMD and GPU architecture\n" +
//                        "Review of Memory Hierarchy - Introduction, Cache performance, Six basic cache optimization, Virtual Memory\n" +
//                        "Thread-Level Parallelism TLP / Issues in Multicore processors - Introduction, Centralized shared-memory\n" +
//                        "architectures, Performance of Symmetric shared memory multiprocessors, Models of memory consistency, Distributed\n" +
//                        "Shared memory and directory based coherence, Synchronization: basics\n");
//                cs6c4.put("Textbook", "1. Computer Organization and Design: The hardware/software Interface (ARM edition) by John L Hennessy &\n" +
//                        "David A Patterson (This book will be referred to as COD)\n" +
//                        "2. Computer Architecture: A Quantitative Approach, 5th Edition By John L Hennessy & David A Patterson (you\n" +
//                        "may use earlier editions. It may have different Chapter numbers) (CAQA)\n");
//                //cs6c4.put("Reference Book", "");
//                cs6c4.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 6").document
//                        ("Computer Architecture ").set(cs6c4, SetOptions.merge());
//
//
//                // CS Semester 6 Introduction to Cryptography and Security details
//                Map<String, Object> cs6c5 = new HashMap<>();
//                cs6c5.put("Course Contents", "Secret Key Cryptography: Substitution-Permutation Network; Feistel structure; block ciphers - DES, AES, IDEA;\n" +
//                        "stream ciphers – LFSR, RC4, eStream ciphers.\n" +
//                        "Modes of operation: ECB, CBC, CFB, CTR, OFB.\n" +
//                        "Data Integrity: Hash functions – MD5, SHA; Message Authentication Codes.\n" +
//                        "Public Key Cryptography: Integer Factorization Problems - RSA, Rabin's scheme; Discrete Logarithm Problems -\n" +
//                        "Diffie-Hellman, ElGamal, DSA; CRT; Elliptic Curves arithmetic - ECDSA, identity-based crypto; PKI.\n" +
//                        "Security Models: CPA, CCA/CCA2.\n" +
//                        "Kerberos; E-Mail Security; SSL/TLS; Web security; Systems security; Access controls; Malwares; Firewalls;\n" +
//                        "Intruders.\n");
//                cs6c5.put("Textbook", "1) Introduction to Cryptography with Coding Theory -- Washington & Trappe, [Pearson Education], 2009.\n" +
//                        "2) Introduction to Modern Cryptography -- Katz & Lindell, [CRC press], 2007.\n" +
//                        "3) Computer Security: Art and Science -- M. Bishop, [Pearson Education], 2004.\n");
//                cs6c5.put("Reference Book", "1) Applied Cryptography: Protocols, Algorithms, and Source Code in C -- Bruce Schneier, [John Wiley & Sons].\n" +
//                        "2) Network Security -- Kaufman, Perlman and Speciner, [Pearson Education], 2002.\n" +
//                        "3) Cryptography and Network Security -- W. Stallings, [Prentice Hall], 2010.\n" +
//                        "2) Handbook of Applied Cryptography -- A. Menezes, P. van Oorschot and S. Vanstone [CRC press]\n");
//                cs6c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 6").document
//                        ("Introduction to Cryptography and Security").set(cs6c5, SetOptions.merge());
//
//
//                // CS Semester 6 Science Elective – 2 details
//                Map<String, Object> cs6c6 = new HashMap<>();
//                //cs6c6.put("Course Contents", "");
//                //cs6c6.put("Textbook", "");
//                //cs6c6.put("Reference Book", "");
//                cs6c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 6").document
//                        ("Science Elective – 2").set(cs6c6, SetOptions.merge());
//
//
//                // CS Semester 6 Humanities Elective – 1 details
//                Map<String, Object> cs6c7 = new HashMap<>();
//                //cs6c7.put("Course Contents", "");
//                //cs6c7.put("Textbook", "");
//                //cs6c7.put("Reference Book", "");
//                cs6c7.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 6").document
//                        ("Humanities Elective – 1").set(cs6c7, SetOptions.merge());
//
//
//
//                // CS Semester 7 Professional Ethics details
//                Map<String, Object> cs7c1 = new HashMap<>();
//                cs7c1.put("Course Contents", "HUMAN VALUES: Morals, values and ethics, integrity; service learning; civic virtue; respect for others; sharing;\n" +
//                        "honesty; courage; valuing time; cooperation; commitment; empathy; self-confidence; spirituality.\n" +
//                        "ENGINEERING ETHICS: Senses of Engineering Ethics; moral dilemmas, moral autonomy; Kohlberg’s theory;\n" +
//                        "Gilligan’s theory; consensus and controversy; models of professional roles; theories about right action; self-interest;\n" +
//                        "customs and religion; uses of ethical theories.\n" +
//                        "ENGINEERING AS SOCIAL EXPERIMENTATION: Engineers as responsible experimenters; codes of ethics; case\n" +
//                        "study.\n" +
//                        "SAFETY, RESPONSIBILITIES AND RIGHTS: Safety and risk; assessment of safety and risk; risk benefit analysis\n" +
//                        "and reducing risk; the three mile island and chernobyl case studies.\n" +
//                        "COLLEGIALITY AND LOYALTY: Respect for authority; collective bargaining; confidentiality; conflicts of interest;\n" +
//                        "occupational crime; professional rights; employee rights; Intellectual Property Rights (IPR); discrimination.\n" +
//                        "GLOBAL ISSUES: Multinational corporations; environmental ethics; computer ethics; weapons development;\n" +
//                        "engineers as managers; consulting engineers; engineers as expert witnesses and advisors; moral leadership; sample\n" +
//                        "code of ethics like ASME, ASCE, IEEE, IE (India), IETE (India).\n");
//                cs7c1.put("Textbook", "Engineering Ethics, C. D. Fleddermann, Pearson Education/ Prentice Hall, New Jersey, 2004.\n");
//                cs7c1.put("Reference Book", "1) Ethics in engineering, M. Martin, R. Schinzinger, McGraw-Hill, New York1996.\n" +
//                        "2) Engineering Ethics – Concepts and Cases, C. E. Harris, M. S. Pritchard, M. J Rabins, Thomson Learning, United\n" +
//                        "States, 2000.\n");
//                cs7c1.put("Credits", "Lecture-2\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-2");
//
//                db.collection("BTECH").document("CS").collection("Semester 7").document
//                        ("Professional Ethics ").set(cs7c1, SetOptions.merge());
//
//
//                // CS Semester 7 Distributed Computing details
//                Map<String, Object> cs7c2 = new HashMap<>();
//                cs7c2.put("Course Description", "This course covers the foundations of distributed systems including models of computing, different types of\n" +
//                        "communication (Layered Protocols, Remote Procedure Calls, Remote Objects, messages, streams), process models\n" +
//                        "(threads, client/server, code migration and software agents), naming of entities, logical clocks and synchronization. We\n" +
//                        "will review some of the popular applications of distributed computing including distributed file systems and web\n" +
//                        "services. The course will include two programming assignments, one group project and one project presentation. The\n" +
//                        "programming assignments will provide hands on experience in understanding different types of communications and\n" +
//                        "process models. The project will help develop a reasonably sized distributed application based on research papers that\n" +
//                        "will be discussed during the semester. The expectation is that students have mastered one or more programming\n" +
//                        "languages. Specific language mastery is not important, though knowing one of C, C++, or Java will be helpful. \n");
//                cs7c2.put("Course Contents", "Overview of C, UNIX and UNIX system calls.\n" +
//                        "INTRODUCTION: Definition of a distributed system, goals, hardware concepts, software concepts, the client-server\n" +
//                        "model.\n" +
//                        "COMMUNICATION: Layered Protocols, Remote Procedure Call, Remote Object Invocation, Message-Oriented and\n" +
//                        "Stream-Oriented Communication.\n" +
//                        "PROCESSES: Threads, Servers, Code Migration and Software Agents.\n" +
//                        "NAMING: Naming Entities, Locating Mobile Entities, Removing Unreferenced Entities.\n" +
//                        "SYNCHRONIZATION: Clock Synchronization, Logical Clocks and Election Algorithms.\n");
//                cs7c2.put("Textbook", "A. Tanenbaum, M. V. Steen: Distributed Systems principles and paradigms. Prentice Hall ISBN 0-13-121786-0.\n");
//                cs7c2.put("Reference Book", "G. Coulouris, J. Dollimore, T. Kindberg, Distributed Systems: Concepts and Design. Prentice Hall ISBN\n" +
//                        "0-201-61918-0.\n");
//                cs7c2.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 7").document
//                        ("Distributed Computing").set(cs7c2, SetOptions.merge());
//
//
//
//                // CS Semester 7 Technical Elective – 1 details
//                Map<String, Object> cs7c3 = new HashMap<>();
//                //cs7c3.put("Course Contents", "");
//                //cs7c3.put("Textbook", "");
//                //cs7c3.put("Reference Book", "");
//                cs7c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 7").document
//                        ("Technical Elective – 1").set(cs7c3, SetOptions.merge());
//
//
//
//                // CS Semester 7 Technical Elective – 2 details
//                Map<String, Object> cs7c4 = new HashMap<>();
//                //cs7c4.put("Course Contents", "");
//                //cs7c4.put("Textbook", "");
//                //cs7c4.put("Reference Book", "");
//                cs7c4.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 7").document
//                        ("Technical Elective – 2").set(cs7c4, SetOptions.merge());
//
//
//
//                // CS Semester 7 Technical Elective – 3 details
//                Map<String, Object> cs7c5 = new HashMap<>();
//                //cs7c5.put("Course Contents", "");
//                //cs7c5.put("Textbook", "");
//                //cs7c5.put("Reference Book", "");
//                cs7c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("CS").collection("Semester 7").document
//                        ("Technical Elective – 3 ").set(cs7c5, SetOptions.merge());
//
//
//
//                // CS Semester 7 Technical Elective – 4 details
//                Map<String, Object> cs7c6 = new HashMap<>();
//                //cs7c6.put("Course Contents", "");
//                //cs7c6.put("Textbook", "");
//                //cs7c6.put("Reference Book", "");
//                cs7c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("CS").collection("Semester 7").document
//                        ("Technical Elective – 4 ").set(cs7c6, SetOptions.merge());
//
//
//
//                // CS Semester 8 Project details
//                Map<String, Object> cs8p = new HashMap<>();
//                cs8p.put("Description", "Final semester project is a guided project. Students can take individual project or group project. In case it is a group\n" +
//                        "project the size of the group would be restricted to not more than two students. Students would be allowed to\n" +
//                        "undertake their final semester project outside the Institute. Students can undertake such projects in any other\n" +
//                        "educational institute or in a research lab. Students would also be allowed to join industry for this final semester project\n" +
//                        "in case the nature of the project is based on some research.\n");
//                //cs8p.put("Textbook", "");
//                //cs8p.put("Reference Book", "");
//                cs8p.put("Credits", "Lecture-0\n" + "Tutorial-0\n" + "Practical-36\n" + "Total-18");
//
//                db.collection("BTECH").document("CS").collection("Semester 8").document
//                        ("Project").set(cs8p, SetOptions.merge());
//
//
//                // CS Summer 1 Design Project details
//                Map<String, Object> cssdp1 = new HashMap<>();
//                //cssdp1.put("Description", "");
//                //cssdp1.put("Textbook", "");
//                //cssdp1.put("Reference Book", "");
//                cssdp1.put("Credits", "Pass/Fail");
//
//                db.collection("BTECH").document("CS").collection("Summer 1").document
//                        ("Design Project").set(cssdp1, SetOptions.merge());
//
//
//
//                // CS Summer 2 Design Project details
//                Map<String, Object> cssdp2 = new HashMap<>();
//                //cssdp2.put("Description", "");
//                //cssdp2.put("Textbook", "");
//                //cssdp2.put("Reference Book", "");
//                cssdp2.put("Credits", "Pass/Fail");
//
//                db.collection("BTECH").document("CS").collection("Summer 2").document
//                        ("Design Project").set(cssdp2, SetOptions.merge());
//
//
//
//                // IT Semester 1 Introduction to Discrete Mathematics details
//                Map<String, Object> it1c1 = new HashMap<>();
//                it1c1.put("Course Contents", "FOUNDATION: Propositional and predicate logic, logical equivalences, predicates and quantifiers,\n" +
//                        "translation from language to logical expressions, nested quantifiers, set theory, set operations, set identities and\n" +
//                        "functions, inverse and composition functions, graph of functions.\n" +
//                        "NUMBER THEORY: Division operator, prime factorization, properties of prime numbers, prime number theorem,\n" +
//                        "GCD and LCM, modular arithmetic and applications, sequences and summations.\n" +
//                        "COUNTING: Permutation and combinations, pigeonhole principle, inclusion-exclusion principle, binomial theorem,\n" +
//                        "Pascal identity and triangle.\n" +
//                        "MATHEMATICAL REASONING and INDUCTION: Rules of inference, direct proof, proof by contradiction, proof\n" +
//                        "by contrapositive, mathematical induction and second law of mathematical induction.\n" +
//                        "RECURSION: Definition, recursive algorithm, recurrence relations, solving recurrence relations.\n" +
//                        "RELATIONS: Relations and their properties, applications and representations, equivalence relations, partial ordering,\n" +
//                        "Hasse diagram.\n" +
//                        "GRAPHS: Introduction and terminology, representation, isomorphism, connectivity, Warshall‘s algorithm, Euler and\n" +
//                        "Hamilton path, shortest path.\n");
//                it1c1.put("Textbook", "Discrete Mathematics and its Application, 7th Ed, K. Rosen, Tata McGraw Hill, 2011.");
//                it1c1.put("Reference Book", "1) Discrete Mathematical Structure, 4th Ed, B. Kolman, R.C. Busby and S. C. Ross, PHI, 2000.\n" +
//                        "2) Discrete Mathematics, Richard Johnsonbaugh, Prentice Hall, 2007.\n" +
//                        "3) Mathematics: A Discrete Introduction, 3rd Ed., Edward R. Scheinerman, Cengage Learning, 2006.\n" +
//                        "4) Mathematical Structure for Computer Science, 6th Ed, J. Gersting, Freeman, 2006.\n");
//                it1c1.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-4");
//
//
//                db.collection("BTECH").document("IT").collection("Semester 1").document
//                        ("Intoduction to Discrete Mathematics").set(it1c1, SetOptions.merge());
//
//
//                // IT Semester 1 Physics details
//                Map<String, Object> it1c2 = new HashMap<>();
//                it1c2.put("Course Contents", "COORDINATE SYSTEM: Cartesian, cylindrical and spherical coordinates; unit vectors and their time derivatives.\n" +
//                        "REVIEW OF PARTICLE DYNAMICS: Inertial and non-inertial frames of reference, centrifugal and coriolis forces;\n" +
//                        "conservative force, work-energy theorem; centre of mass, conservation of momentum; collision in one and two\n" +
//                        "dimensions. small oscillations, free, forced and damped oscillations.\n" +
//                        "ATOMIC PHYSICS: Rutherford and Bohr's atomic model, quantum numbers, atomic spectra, energy levels.\n" +
//                        "ELEMENTARY PARTICLES: Nuclear model, protons and neutrons, nuclear force, introduction of elementary\n" +
//                        "particles.\n" +
//                        "CONCEPTUAL FOUNDATION of MODERN PHYSICS: Electromagnetic waves, blackbody radiation, Planck’s law\n" +
//                        "of radiation, photoelectric effect, wave-particle duality, Compton wavelength, de-Broglie wave, Heisenberg’s\n" +
//                        "uncertainty principle, contribution of Dirac, Pauli, Schrodinger and Born in foundation of quantum mechanics, topics\n" +
//                        "in Quantum Mechanics.\n" +
//                        "INTRODUCTION TO APPLIED PHYSICS: A non-mathematical exposure to applied physics such as:\n" +
//                        "pendulum, heat engine, transformer, optical microscope, electron microscope, scanning tunneling microscope, laser\n" +
//                        "diode, photo detector, solar cells, transistors.\n");
//                it1c2.put("Textbook", "Concepts of Modern Physics. A.Beiser, Tata McGraw-Hill, New Delhi, 1995.\n");
//                it1c2.put("Reference Book", "1) Quantum Physics of Atoms, Molecules, Solids, Nuclei and Particles, 2ndEd, R. Eisberg and R. Resnick , John-Wiley,\n" +
//                        "1985.\n" +
//                        "2) Quantum Mechanics: Theory and Applications 5thEd, AjoyGhatak, Macmillan, 2004.");
//                it1c2.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-2\n" + "Total-5");
//
//
//                db.collection("BTECH").document("IT").collection("Semester 1").document
//                        ("Physics").set(it1c2, SetOptions.merge());
//
//
//                // IT Semester 1 Introduction to Programming details
//                Map<String, Object> it1c3 = new HashMap<>();
//                it1c3.put("Course Contents", "INTRODUCTION TO PROGRAMMING: Programming methods, paradigms, problem solving techniques, algorithm\n" +
//                        "development, flow charts.\n" +
//                        "LINUX ENVIRONMENT: Editor, compiler, debugger.\n" +
//                        "BASICS OF PROCEDURAL PROGRAMMING: Constants, variables, expressions, operators, assignment, basic\n" +
//                        "input and output, built-in functions, program debugging.\n" +
//                        "VARIABLES AND OPERATORS: Basic data types, precedence and order of evaluation, pointers, memory allocation\n" +
//                        "of variables.\n" +
//                        "CONTROL STRUCTURES: Selection statements, iteration statements.\n" +
//                        "FUNCTIONS AND PROGRAM STRUCTURE: Return values, actual and formal parameters, parameter passing: call\n" +
//                        "by value versus call by reference, external variables, scope rules, header files, and recursion.\n" +
//                        "ARRAYS: Character arrays, one and two dimensional arrays; pointer arrays, command-line arguments.\n" +
//                        "I/O: ASCII data files, file pointers, end-of-file.\n" +
//                        "BASIC DATA STRUCTURES: Structures, defining new types, enumerations, dynamic memory allocation, dynamic\n" +
//                        "arrays, linked lists and other pointer-based structures.\n");
//                it1c3.put("Textbook", "C How to Program, 6thEd, P Deitel and H Deitel, Prentice Hall of India, 2010.\n");
//                it1c3.put("Reference Book", "1) C programming language, 2ndEd, Kernighan, Brian W. & Ritchie, Dennis M, New Delhi.\n" +
//                        "Prentice Hall of India, 1998.\n" +
//                        "2) A Book on C, 4thEd, Kelley, A.L. and Pohl Ira, Pearson India, 2002\n" +
//                        "3) A Structured Programming Approach Using C, 1stEd.,Forouzan, Behrouz, Course\n" +
//                        "Technology, 2012.\n" +
//                        "4) Practical C Programming, 3rdEd, Oualline, Steve, Shroff Publishers, 2000.\n" +
//                        "5) C programming: The essentials for engineering and scientists, Brooks, David R. New\n" +
//                        "York. Springer, 1999.\n");
//                it1c3.put("Credits", "Lecture-2\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-2");
//
//                db.collection("BTECH").document("IT").collection("Semester 1").document
//                        ("Introduction to Programming").set(it1c3, SetOptions.merge());
//
//
//
//                // IT Semester 1 Introduction to Programming Lab details
//                Map<String, Object> it1c4 = new HashMap<>();
//                it1c4.put("Course Contents", "Lab and take home assignments based on the course “Introduction to Programming”.\n");
//                //it1c4.put("Textbook", "");
//                //it1c4.put("Reference Book", "");
//                it1c4.put("credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 1").document
//                        ("Introduction to Programming Lab").set(it1c4, SetOptions.merge());
//
//
//                // IT Semester 1 Didital Logic Design details
//                Map<String, Object> it1c5 = new HashMap<>();
//                it1c5.put("Course Contents", "NUMBER SYSTEMS: Representations, signed, 1's complement, 2's complement, saturation and overflow in fixed\n" +
//                        "point arithmetic.\n" +
//                        "BOOLEAN ALGEBRA: Axioms and theorems, DeMorgan’s law, universal gate, duality, expression manipulation\n" +
//                        "using axioms and theorems.\n" +
//                        "COMBINATIONAL LOGIC: Introduction to switching algebra, canonical forms, two-level simplification, boolean\n" +
//                        "cube, logic minimization using K-map method, QuineMcCluskey tabular method, minimization for product-of-sum\n" +
//                        "form, minimization for sum-of-product form, multiplexers, demultiplexers, decoders, encoders, hazard free synthesis,\n" +
//                        "Arithmetic circuits, adders, half adder, full adder, BCD adder, ripple carry adder, carry-lookahead adder,\n" +
//                        "combinational multiplier.\n" +
//                        "SEQUENTIAL LOGIC: Simple circuits with feedback, basic latches, clocks, R-S latch, master-slave latch, J-K flip\n" +
//                        "flop, T flip-flop, D flip-flop, storage registers, shift register, ripple counter, synchronous counters, Finite State\n" +
//                        "Machine (Moore/Mealy Machines), FSM with single/multiple inputs and single/multiple outputs etc.\n" +
//                        "HARDWARE DESCRIPTION LANGUAGE: Programming and simulation, structural specification, \n" +
//                        "behavioral specification, dataflow modelling, testbench, testing using test vectors, testing using waveforms, design of\n" +
//                        "basic blocks to build larger circuits, case studies, adder, ALU, counters, shift registers, register bank, FSM design\n" +
//                        "example etc.\n");
//                it1c5.put("Textbook", "Digital Fundamentals,10thEd, Floyd T L, Prentice Hall, 2009.\n");
//                it1c5.put("Reference Book", "1) Digital Design-Principles and Practices, 4thEd, J F Wakerly, Prentice Hall, 2006.\n" +
//                        "2)Digital Design, Morris Mano, Prentice Hall, 2002\n" +
//                        "3) Digital Systems: Principles and Applications, Ronald J. Tocci, Neal S. Widmer, Gregory\n" +
//                        "L. Moss, Pearson Education, Limited, 2011.\n" +
//                        "4) Fundamentals of Digital Logic with Verilog Design, 2nd Ed, S. Brown and Z. Vrsaniec,\n" +
//                        "McGraw Hill, 2007\n");
//                it1c5.put("Credits","Lecture-3\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-5" );
//
//                db.collection("BTECH").document("IT").collection("Semester 1").document
//                        ("Digital Logic Design").set(it1c5, SetOptions.merge());
//
//
//                // IT Semester 1 Spoken and written Communication details
//                Map<String, Object> it1c6 = new HashMap<>();
//                it1c6.put("Course Contents", "Unit-I:\n" +
//                        "Course Instructor should make an optimal use of cinema for increasing the students’ familiarity with English. Testing\n" +
//                        "be done on the basis of the student’s comprehension of the plot and the ability of describe scenes from the film. Class\n" +
//                        "room exercise of asking students to comment on the plot or scenes of a given film – not in writing but by standing\n" +
//                        "before the entire class and speaking in English — be frequently carried out. The aim of this unit is to make the student\n" +
//                        "feel confident about her/his ability to form sentence in English for discursive communication.\n" +
//                        "Unit-II:\n" +
//                        "Course Instructor should use audio tapes, Ted Lectures, radio news broadcast or celebrated speeches, etc for exposing\n" +
//                        "the students’ to a ̳real time‘ and good spoken English. Class room tests be set to check the students’ ability to respond\n" +
//                        "to their listening experience in writing. This will help the Course Instructor to continually assess the requirements of\n" +
//                        "the students and provide corrective advise. Testing the writing skills of students will require setting several questions\n" +
//                        "of very short composition tasks, from 50 words to 150 words. The topics chosen for the composition tasks should be\n" +
//                        "selected from the topics covered in the classroom discussions or from the life on the campus.\n" +
//                        "Unit-III:\n" +
//                        "Students should be provided four to five extended samples of written English such as short stories or newspaper\n" +
//                        "editorials for them to mark their difficulties – words, idioms, sentence structures, etc. This will help the students in\n" +
//                        "improving their ability to do focused reading of serious written literature. Testing of the reading comprehension skills\n" +
//                        "be tested by giving them in advance of the test several passages for reading. The Course Instructor may select one or\n" +
//                        "more of those seen passages’ for the examination purpose.\n");
//                it1c6.put("Textbook", "Prism: Spoken and Written Communication, Prose & Poetry published by Orient Longman, 2008.\n");
//                it1c6.put("Reading Materials", "The Bet – Anton Chekov\n" +
//                        "Socrates and the Schoolmaster – F. L. Brayne\n" +
//                        "An Astrologer‘s Day – R. K. Narayan\n" +
//                        "The Gift of the Magi – O’ Henry\n" +
//                        "With the Photographer – Stephen Leacock\n" +
//                        "Speech on Indian Independence – Jawaharlal Nehru.\n");
//                it1c6.put("Credits", "Lecture-2\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-2");
//
//                db.collection("BTECH").document("IT").collection("Semester 1").document
//                        ("Spoken and written Communication").set(it1c6, SetOptions.merge());
//
//
//                // IT Semester 2 Calculus details
//                Map<String, Object> it2c1 = new HashMap<>();
//                it2c1.put("Course Contents", "FUNDAMENTALS: Limits, continuity, differentiability, mean value theorems, and Taylor‘s theorem; fundamental\n" +
//                        "theorem of integral calculus, definite integrals, trapezoidal and Simpson’s rule; sequences and series, tests for\n" +
//                        "convergence: absolute and conditional convergence; power series and radius of convergence.\n" +
//                        "FUNCTIONS OF SEVERAL VARIABLES: Partial derivatives, chain rule, gradient and directional derivative;\n" +
//                        "Taylor’s theorem for functions of several variables; maxima, minima and saddle points.\n" +
//                        "VECTOR CALCULUS: Gradient, divergence and curl. double, triple, line and surface integrals; theorems of Green,\n" +
//                        "Gauss, Stokes and their applications.\n" +
//                        "INTRODUCTION TO COMPLEX VARIABLES: Complex numbers and the complex plane, derivative and analytic\n" +
//                        "functions.\n" +
//                        "DIFFERENTIAL EQUATIONS: First order equations, second linear differential equations, partial differential\n" +
//                        "equations basic concepts and important examples, Laplace and Fourier transforms. \n");
//                it2c1.put("Textbook", "Calculus and Analytical Geometry, 9th Ed, G B Thomas and R L Finney, Addison-Wesley, 1999.\n");
//                it2c1.put("Reference Book", "1) Differential and Integral Calculus, 3th Ed, Schaum’s Outline Series, McGraw Hill, 1992.\n" +
//                        "2) Advanced Engineering Mathematics, 8th Ed, R. Kreyszig, John Wiley, 1999.\n");
//                it2c1.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 2").document
//                        ("Calculus").set(it2c1, SetOptions.merge());
//
//                // IT Semester 2 Data Structures details
//                Map<String, Object> it2c2 = new HashMap<>();
//                it2c2.put("Course Contents", "INTRODUCTION: Representation of data on a computer, data types & array and linked list representations ways of\n" +
//                        "representing programs and associated data on computers\n" +
//                        "ANALYSIS TOOLS: Notion of the running time of an algorithm, recurrences, parameters of\n" +
//                        "performance.\n" +
//                        "DICTIONARY OPERATIONS: Find, max, min, successor, predecessor (query operations); insert, delete (modify\n" +
//                        "operations)\n" +
//                        "LIST DATA: Stacks, queues, variants implementation using arrays and linked lists\n" +
//                        "SORTING: Comparison based sorting algorithms, other sorting algorithms, lower bounds for\n" +
//                        "comparison-based sorting algorithms best-case, worst-case and average-case running times;\n" +
//                        "quicksort, heap Sort, insertion sort, bubble sort etc.\n" +
//                        "ORDER STATISTICS: Maximum and minimum elements of a set, Finding median, searching for an element of a\n" +
//                        "given rank, finding the rank of a given element, ranks of a subset of elements,\n" +
//                        "maintaining rank information for a dynamic set.\n" +
//                        "TREES: heaps, Binary search trees (BST), heights of BST\n" +
//                        "BALANCED BSTs: Red Black trees, AVL Trees, 2,3,4-trees, B Trees\n" +
//                        "GRAPHS: Representation using adjacency matrices and adjacency lists, Graph searching algorithms BFS and DFS.\n");
//                it2c2.put("Textbook", "Data Structures and Algorithms, Aho, Hopcroft and Ullman, Addison-Wesley, 1999.\n");
//                it2c2.put("Reference Book", "Introduction to Algorithms, 3th Ed, Cormen, Lieserson and Rivest, PHI, 2011.\n");
//                it2c2.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 2").document
//                        ("Data Structures").set(it2c2, SetOptions.merge());
//
//
//                // IT Semester 2 Data Structures Lab details
//                Map<String, Object> it2c3 = new HashMap<>();
//                it2c3.put("Course Contents", "Lab and take home assignments based on the course “Data Structures”. It is essential for the instructor to use the\n" +
//                        "tutorial hours of this course to give hands on of any object oriented programming language so that students can code\n" +
//                        "the assignments given.\n");
//                //it2c3.put("Textbook", "");
//                //it2c3.put("Reference Book", "");
//                it2c3.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 2").document
//                        ("Data Structures Lab").set(it2c3, SetOptions.merge());
//
//
//                // IT Semester 2 Basic Electronic Circuits details
//                Map<String, Object> it2c4 = new HashMap<>();
//                it2c4.put("Course Contents", "ANALOG CIRCUIT ELEMENTS: Resistor, Capacitor, Inductor, Concepts of LLFPB, Non-linear circuit elements,\n" +
//                        "Incremental equivalent of nonlinear elements, Voltage and Current sources, Controlled sources, Active circuits,\n" +
//                        "Practical circuit elements of different types.\n" +
//                        "ANALYSIS OF LINEAR CIRCUITS: Kirchhoff‘s laws, D-C analysis of resistive circuits, Time-domain\n" +
//                        "analysis of a-c circuits ,Sinusoidal steady state analysis of a-c circuits – notions of phasors, impedance, transfer\n" +
//                        "function and frequency response, Frequency response vs transient response , Superposition theorem, Thevenin’s and\n" +
//                        "Norton’s theorems, Two-port parameters, Analysis of circuits having controlled sources.\n" +
//                        "AMPLIFIERS: Diodes, BJT, FET, Amplifier parameters, Controlled source models, Active devices as controlled\n" +
//                        "sources, Different amplifier configuration using the OPAMP, Frequency response of OPAMP and OPAMP-based\n" +
//                        "amplifiers, Power amplifiers using OPAMP and transistors.\n" +
//                        "OSCILLATORS: Amplifier with feedback, Condition of harmonic oscillation, RC oscillator circuits.\n" +
//                        "WAVEFORM GENERATORS: OPAMP as a comparator, Regenerative comparator, Timer, Relaxation\n" +
//                        "oscillator, Non-sinusoidal waveform generator using comparator.\n" +
//                        "D-C POWER SUPPLY: Half-wave and full-wave rectifiers, Shunt capacitor filter, Ripple and voltage\n" +
//                        "regulation, Voltage regulator using zener diode, Active voltage regulator.\n");
//                it2c4.put("Textbook", "1) Electronic Principles, 7th Ed, Albert Malvino, and David Bates, Tata McGraw-Hill, 2006.\n" +
//                        "2) Microelectronic circuits, 5th Ed, A Sedra , K Smith, A N Chandorkar, Oxford University Press,2009.\n");
//                it2c4.put("Reference Book", "1) Network Analysis, 3th Ed, Van Valkenburg, PHI, 2000.\n" +
//                        "2) Introduction to electric circuits, 8th Ed, R C. Dorf and J A Svoboda John Wiley, 2000.\n" +
//                        "3) Engineering Circuit Analysis, 6th Ed, William H.Hayt, Jack Kemmerly , Steven Durbin, Tata McGraw-Hill, 2002.\n" +
//                        "4) Electric circuit fundamentals, Sergio Franco, Oxford University Press, 1995.\n" +
//                        "5) Foundations of Analog and Digital Electronic Circuits, Anant Agarwal and Jeffrey Lang,\n" +
//                        "Morgan Kaufman, 2005.\n");
//                it2c4.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-2\n" + "Total-5");
//
//                db.collection("BTECH").document("IT").collection("Semester 2").document
//                        ("Basic Electronic Circuits").set(it2c4, SetOptions.merge());
//
//
//                // IT Semester 2 Computer Organization details
//                Map<String, Object> it2c5 = new HashMap<>();
//                it2c5.put("Course Contents", "von NEUMANN MACHINE: Functional units, stored program concept, ALU, data paths, registers, status flags;\n" +
//                        "instruction cycle.\n" +
//                        "DATA REPRESENTATION: Integer data; fixed and floating point systems; representation of non-numeric data\n" +
//                        "(characters, strings, records, and arrays).\n" +
//                        "ASSEMBLY/MACHINE LEVEL: Instruction sets and types (arithmetic, data movement, and control); instruction\n" +
//                        "formats and addressing modes, subroutine call and return mechanisms; representations of fundamental high-level\n" +
//                        "programming constructs at the assembly language\n" +
//                        "level; Heap vs. Stack vs. Static vs. Code segments.\n" +
//                        "MEMORY SYSTEM: Principles of temporal and spatial locality; cache memories (address mapping, block size,\n" +
//                        "replacement and store policy); virtual memory (page table, TLB); disk organization and data access from disk drive.\n" +
//                        "I/O COMMUNICATION: Handshaking, buffering, programmed I/O, interrupt-driven I/O, bus protocols.\n");
//                it2c5.put("Textbook", "1) Introduction to Computing Systems: From Bits and Bytes to C and Beyond, 2th Ed, Yale Patt and Sanjay Patel, Tata\n" +
//                        "McGraw-Hill, 2001.\n" +
//                        "2) Computer Systems: A Programmer’s Perspective, 1st Ed Bryant and O’Hallaron, Pearson, 2002.\n");
//                it2c5.put("Reference Book", "1) The Essentials of Computer Architecture and Organization, 3rd Ed, Null and Lobur, Jones & Bartlett/Viva Books,\n" +
//                        "2011.\n" +
//                        "2) Structured Computer Organization, 6th Ed, Tanenbaum and T Austin, Pearson, 2012.\n" +
//                        "3) Computer Organization and Architecture, 8th Ed, Stallings, Pearson, 2010.\n" +
//                        "4) Computer System Organization, N. Jotwani, Tata McGraw Hill, 2009.\n");
//                it2c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-5");
//
//                db.collection("BTECH").document("IT").collection("Semester 2").document
//                        ("Computer Organization").set(it2c5, SetOptions.merge());
//
//
//                // IT Semester 2 Introduction to Information Technology details
//                Map<String, Object> it2c6 = new HashMap<>();
//                it2c6.put("Course Contents", "Students of BTech CS and BTech IT, will take this course separately. These courses aim at introducing the broad\n" +
//                        "perspective of computer science and information technology to the respective students. Students get to understand the\n" +
//                        "breadth of the subject area they would be exploring in the coming years. It is expected that more than one faculty\n" +
//                        "instructor would deliver the lectures of these courses.\n" +
//                        "The course content of Intro. to IT is composed of following four modules.\n" +
//                        "Module 1\n" +
//                        "This module starts with discussions on different aspects of information technology in organization from business,\n" +
//                        "economic and social perspectives. It then follows computer hardware and software requirement in organizational\n" +
//                        "needs in order to meet various aspects of IT/ITeS usage in real-world applications. The module ends with highlighting\n" +
//                        "important factors of data and knowledge management in organization.\n" +
//                        "Module 2\n" +
//                        "This module brings up IT revolution in communication medium and computing paradigms. The coverage of all these\n" +
//                        "aspects would focus on the topics that how IT technologies have been evolving in past two decades and how things\n" +
//                        "would move in coming years to come.\n" +
//                        "Module 3\n" +
//                        "This module emphasizes on applications, implementation, and integration aspects of IT/ITeS usage in competitive\n" +
//                        "advantage. The module will illustrate how does an enterprise system function? CRM issues get resolved and so on.\n" +
//                        "The last part of this module will discuss e-commerce scenarios and applications.\n" +
//                        "Module 4\n" +
//                        "This module focuses on decision support system, managerial involvement, data acquisition, repository, and recovery\n" +
//                        "aspects. The module concludes with stressing on ethical practice and legal aspects while handling IT technologies and\n" +
//                        "data. \n");
//                it2c6.put("Textbook", "Introduction to Information Technology, 3/e -- Turban, Rainer, Potter. John Wiley & Sons, 2005.\n" +
//                        "Online resource: http://bcs.wiley.com/he-bcs/Books?action=contents&itemId=0471347809&bcsId=1918\n" +
//                        "[All four modules of the course have been designed based on the chapters given in the book. Adequate\n" +
//                        "materials and supplementary notes available online in the site mentioned above. ] \n");
//                // it2c6.put("Reference Book", "");
//                it2c6.put("Credits", "Lecture-1\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-2");
//
//                db.collection("BTECH").document("IT").collection("Semester 2").document
//                        ("Introduction to Information Technology").set(it2c6, SetOptions.merge());
//
//
//
//                // IT Semester 3 Object Oriented Design and Programming  details
//                Map<String, Object> it3c1 = new HashMap<>();
//                it3c1.put("Course Contents", " INTRODUCTION: Principles of OOD; programming Paradigms; benefits of OOD&P, applications\n" +
//                        "of OOD; Classes and objects; access qualifiers; instance creation; constructors, parameterized constructors,\n" +
//                        "overloaded constructors, constructors with default arguments, copy constructors, static class members and static\n" +
//                        "objects.\n" +
//                        "FUNCTIONS an OPERATORS: Function prototyping, function components, passing parameters, inline functions,\n" +
//                        "default arguments, overloaded function; array of objects, pointers to objects, dynamic allocation operators, dynamic\n" +
//                        "objects; Operator overloading, overloading unary and binary operator, overloading the operator using friend function,\n" +
//                        "stream operator overloading, data conversion.\n" +
//                        "INHERITANCE: Defining derived classes, single inheritance, protected data with private inheritance, multiple\n" +
//                        "inheritance, multi level inheritance, hierarchical inheritance, hybrid inheritance, multipath inheritance, constructors in\n" +
//                        "derived and base class, abstract classes, virtual function and dynamic polymorphism, virtual destructor.\n" +
//                        "EXCEPTION HANDLING: Principle of exception handling, exception handling mechanism, multiple catch, nested\n" +
//                        "try, re/throwing the exception.\n" +
//                        "OBJECT ORIENTED DESIGN: Requirements modeling, business modeling, component based development;\n" +
//                        "Rational Unified Process (RUP), process overview, phases and iterations, static structure of the process, core\n" +
//                        "workflows; UML history, building blocks of UML, structural modeling, behavioral modeling; Use Case Diagrams,\n" +
//                        "Modeling Ordered Interactions: Sequence Diagrams; case studies.\n");
//                it3c1.put("Textbook", "1) Introduction to object-oriented programming, B. Timothy, Pearson, 2001.\n" +
//                        "2) Applying UML and Patterns: An Introduction to Object-Oriented Analysis and Design and Iterative Development,\n" +
//                        "C. Larman , Prentice Hall, 2004.\n");
//                it3c1.put("Reference Book", "1) Object Oriented Design and Patterns, C. Horstmann, John Wiley & Sons, 2005.\n" +
//                        "2) Unified Modeling Language User Guide, G. Booch, J. Rumbaugh, I. Jacobson, Pearson Education, 2001.\n" +
//                        "3) Object-Oriented Systems Analysis and Design using UML, Bennett, McRobb, Farmer, McGraw-Hill, 2002\n");
//                it3c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 3").document
//                        ("Object Oriented Design and Programming").set(it3c1, SetOptions.merge());
//
//                // IT Semester 3 Object Oriented Design and Programming Lab details
//                Map<String, Object> it3c2 = new HashMap<>();
//                it3c2.put("Course Contents", " Lab and take home assignments based on the course “OOD & P”. Emphasis on following topics:\n" +
//                        "\uF0A7 Eclipse (or NetBeans) IDE introduction\n" +
//                        "\uF0A7 Compiling & running programs on IDE\n" +
//                        "\uF0A7 Object oriented coding conventions\n" +
//                        "\uF0A7 Simple example of object-oriented design and message passing\n" +
//                        "\uF0A7 Problems on object based iteration\n" +
//                        "\uF0A7 Problems on object based arrays, matrices, and strings\n" +
//                        "\uF0A7 Design oriented problems on object polymorphism\n" +
//                        "\uF0A7 Design oriented problems on object inheritance & overriding\n" +
//                        "\uF0A7 Object-oriented designing of advanced data structures (linked list, trees, graphs, tables)\n" +
//                        "\uF0A7 Problems on object based linked lists\n" +
//                        "\uF0A7 Problems on object based trees\n" +
//                        "\uF0A7 Problems on object based graphs\n" +
//                        "\uF0A7 Mini Projects");
//                //it3c2.put("Textbook", "");
//                //it3c2.put("Reference Book", "");
//                it3c2.put("credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 3").document
//                        ("Object Oriented Design and Programming Lab").set(it3c2, SetOptions.merge());
//
//
//                // IT Semester 3 Information Technology in Knowledge Society details
//                Map<String, Object> it3c3 = new HashMap<>();
//                it3c3.put("Course Contents", " The course consists of four modules.\n" +
//                        "Module 1\n" +
//                        "Introduction: Introduction to knowledge society; factors in knowledge society; digital age; information architecture -\n" +
//                        "concepts and principles; information architecture practice; human computer interaction; information storage;\n" +
//                        "information retrieval; strategic information management and leadership.\n" +
//                        "Module 2\n" +
//                        "Social networks analysis: Actors and actions in social networks; relational ties; network models; inter-dependency;\n" +
//                        "third-party service; trust and ownership; user behavior, patterns; privacy.\n" +
//                        "Module 3\n" +
//                        "Digital Library: Libraries and information organizations; modern documentary tradition; digital libraries; e-science\n" +
//                        "and digital humanities; ethics; plagiarism.\n" +
//                        "Module 4\n" +
//                        "Digital Economy: introduction to e-commerce, B2B, B2C, C2C; plastic money, e-cash/coin; mobile payment;\n" +
//                        "strengths and constraints; economic and social perception in digital economy.\n");
//                it3c3.put("Textbook", "1) Fundamentals of information studies, J. Lester, W. Koehler, Neal-Schuman Publishers, 2007.\n" +
//                        "2) Information Technology for Management, 8/e -- Turban, Volonino. John Wiley & Sons, 2011.\n");
//                it3c3.put("Reference Book", "Research Methods, C. H. Busha, Encyclopedia of Library and Information Science, Volume25, pp. 254-293, Marcel\n" +
//                        "Dekker Inc., New York.\n");
//                it3c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 3").document
//                        ("Information Technology in Knowledge Society").set(it3c3, SetOptions.merge());
//
//
//                // IT Semester 3 Algorithms and Problem Solving details
//                Map<String, Object> it3c4 = new HashMap<>();
//                it3c4.put("Course Contents", "INTRODUCTION: Definition, properties of algorithms, analysis of algorithms.\n" +
//                        "DIVIDE AND CONQUER: Binary search, maximum and minimum element, analysis of sorting and searching\n" +
//                        "algorithms.\n" +
//                        "GREEDY METHOD: Optimal storage on tapes, Knapsack problem, Minimum spanning trees, Single source shortest\n" +
//                        "path method.\n" +
//                        "DYNAMIC PROGRAMMING: All pairs shortest path, Optimal binary tree, Multistage graphs.\n" +
//                        "BACKTRACKING: Solution space and tree organization, The Eight Queens problem, sum of subset problem, Graph\n" +
//                        "coloring, Knapsack problem.\n" +
//                        "BRANCH AND BOUND: O/I Knapsack problem, traveling sales person problem, efficiency measures.\n" +
//                        "NP HARD AND NP COMPLETE PROBLEMS: Basic concepts, problems and applications. \n");
//                it3c4.put("Textbook", "1) Introduction to Algorithms, 3th Ed -- Cormen, Lieserson and Rivest, PHI, 2011.\n" +
//                        "2) How to Solve it by Computers -- Dromey, Pearson, 2007 \n");
//                it3c4.put("Reference Book", "1) Fundamental Algorithms- The Art of Computer Programming, Vol- I, 2nd Ed, Donald E. Knuth, Narosa Publishing\n" +
//                        "House, Bombay, 2002.\n" +
//                        "2) Fundamentals of Computer Algorithms, 2nd Ed, E. Horowitz, S.Sahni, S.Rajasekaran, Galgotia Publications, New\n" +
//                        "Delhi, 2003.\n" +
//                        "3) Design and Analysis of Algorithms, 3rd Ed, Aho A V, J E Hopcroft, J D Ullman, Pearson Education, Singapore,\n" +
//                        "2000.\n");
//                it3c4.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 3").document
//                        ("Algorithms and Problem Solving").set(it3c4, SetOptions.merge());
//
//
//                // IT Semester 3 Probability and Statistics  details
//                Map<String, Object> it3c5 = new HashMap<>();
//                it3c5.put("Course Contents", "INTRODUCTION: Classical, relative frequency and axiomatic definitions of probability, addition rule and conditional\n" +
//                        "probability, multiplication rule, total probability, Bayes’ theorem and independence.RANDOM VARIABLES:\n" +
//                        "Discrete, continuous and mixed random variables, probability mass, probability density and cumulative distribution\n" +
//                        "functions, mathematical expectation, moments, probability and moment generating function, median and quantiles,\n" +
//                        "Markov inequality, Chebyshev’s inequality.SPECIAL DISTRIBUTIONS: Discrete uniform, binomial, geometric,\n" +
//                        "negative binomial, hypergeometric, Poisson, continuous uniform, exponential, gamma, beta, normal, lognormal,\n" +
//                        "inverse Gaussian, Cauchy, double exponential distributions, reliability and hazard rate, reliability of series and parallel\n" +
//                        "systems.JOINT DISTRIBUTIONS: Joint, marginal and conditional distributions, product moments, correlation and\n" +
//                        "regression, independence of random variables, bivariate normal distribution.TRANSFORMATIONS: functions of\n" +
//                        "random vectors, distributions of order statistics, distributions of sums of random variables.SAMPLING\n" +
//                        "DISTRIBUTIONS: Mean, median, variance, standard deviation, The Central Limit Theorem, distributions of the\n" +
//                        "sample mean and the sample variance for a normal population, Chi-Square, t and F distributions. ESTIMATION:\n" +
//                        "Unbiasedness, consistency, the method of moments and the method of maximum likelihood estimation, confidence\n" +
//                        "intervals for parameters in one sample and two sample problems of normal populations, confidence intervals for\n" +
//                        "proportions.TESTING OF HYPOTHESES: Null and alternative hypotheses, the critical and acceptance regions, two\n" +
//                        "types of error, power of the test, the most powerful test and Neyman-Pearson Fundamental Lemma, tests for one\n" +
//                        "sample and two sample problems for normal populations, tests for proportions, Chi square goodness of fit test and its\n" +
//                        "applications.\n");
//                it3c5.put("Textbook", "Introduction to Probability and Statistics for Engineers and Scientists, S. M. Ross, Academic Press, 2009. \n");
//                it3c5.put("Reference Book", "1) Introduction to Probability and Statistics, J.S. Milton & J. C. Arnold, Cengage Learning, 2008\n" +
//                        "2) Introduction to Probability Theory and Statistical Inference, H.J. Larson, Wiley, 1982.\n" +
//                        "3) A First Course in Probability, S.M. Ross, Prentice Hall, 2001.\n");
//                it3c5.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 3").document
//                        ("Probability and Statistics ").set(it3c5, SetOptions.merge());
//
//
//                // IT Semester 3 Economics details
//                Map<String, Object> it3c6 = new HashMap<>();
//                it3c6.put("Course Contents", "The Problems of Economic Organisation; Demand and Supply; Price Determination; Elasticity of Demand and\n" +
//                        "Supply; Theory of Production; Production function; Law of diminishing returns; Analysis of Cost; Fixed and variable\n" +
//                        "costs; Marginal cost; Market Structure and Various Types of Markets; Perfectly Competitive Market; Monopolistic\n" +
//                        "Markets; Aggregate Demand and Aggregate Supply; Determination Of National Income and criticisms; Consumption,\n" +
//                        "Saving and Investment; Business Cycle and remedies; International Trade; Balance of Payment; Case for and against\n" +
//                        "free trade; Economics of banking; Interest rates and demand for money; Role of Central Bank; Inflation:\n" +
//                        "measurement, causes and index numbers.\n");
//                it3c6.put("Textbook", "1) Economics, P. Samuelson & Nordhaus, Tata-McGraw Hill.\n" +
//                        "2) Indian Economy, Ruddar Datt & Sundaram, S. Chand & Co.\n");
//                //cs3c6.put("Reference Book", "");
//                it3c6.put("Credits","Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3" );
//
//                db.collection("BTECH").document("IT").collection("Semester 3").document
//                        ("Economics").set(it3c6, SetOptions.merge());
//
//
//
//
//                // IT Semester 4 Database Management System details
//                Map<String, Object> it4c1 = new HashMap<>();
//                it4c1.put("Course Contents", "INTRODUCTION AND CONCEPTUAL MODELING: Databases and database users; database system concepts and\n" +
//                        "architecture; data modeling using the entity relationship (ER) model; enhanced entity relationship.\n" +
//                        "DATA STORAGE AND INDEXING: Introduction, record storage, and primary file organization index structures for\n" +
//                        "files; single level indexing; multilevel indexing.\n" +
//                        "RELATIONAL MODEL: The relational data model; relational database constraints; relational algebra; relational\n" +
//                        "calculus; relational database design by ER and EER; relational mapping; SQL; the relational database standard;\n" +
//                        "examples of relational database management systems; Oracle.\n" +
//                        "DATABASE DESIGN THEORY AND METHODOLOGY: Functional dependencies and normalization for relational\n" +
//                        "databases, relational database design algorithms and further dependencies.\n" +
//                        "SYSTEM IMPLEMENTATION TECHNIQUES: Query processing and optimization, transaction processing concepts,\n" +
//                        "concurrency control techniques, database recovery techniques .\n" +
//                        "OBJECT AND OBJECT RELATIONAL DATABASES: Object database concepts, the ODMG standard for object\n" +
//                        "databases, object relational systems and SQL.\n" +
//                        "EMERGING APPLICATIONS: Distributed databases and client/server models, XML Database (DTD, XML Schema),\n" +
//                        "Query for XML Database, NoSQL.\n");
//                it4c1.put("Textbook", "Fundamentals of Database Systems, R. Elmasri, S. B. Navathe, Prentice Hall, New Delhi, 2007.\n");
//                it4c1.put("Reference Book", "1) Database System Concepts, A. Silberschatz, H. F. Korth, S. Sudharshan,Tata McGraw Hill, New Delhi, 2005.\n" +
//                        "2) Introduction to Database Systems, C. J. Date, Prentice Hall, New Delhi, 2004.\n");
//                it4c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 4").document
//                        ("Database Management System").set(it4c1, SetOptions.merge());
//
//                // IT Semester 4 Database Management System Lab  details
//                Map<String, Object> it4c2 = new HashMap<>();
//                it4c2.put("Course Contents", "Lab and take home assignments based on the course “DBMS”. Emphasis on following topics:\n" +
//                        "ER MODELING TOOL (ERWin): Introduction to ERWin; Adding Entity types & relations; Forward generation.\n" +
//                        "ABSTRACT QUERY LANGUAGE INTERPRETER (JCup & JFlex): Relational Algebra (syntax, RA interpreter);\n" +
//                        "Domain Relational Calculus (syntax, DRC interpreter); Datalog (syntax, Datalog interpreter).\n" +
//                        "RELATIONAL DATABASE MANAGEMENT SYSTEM (Oracle): SQL* Plus Utility; SQL* Loader Utility;\n" +
//                        "Programming with Oracle using JDBC API.\n" +
//                        "RELATIONAL DATABASE MANAGEMENT SYSTEM (MySQL): MySQL Utility; Bulk loading of data; MySQL\n" +
//                        "and PHP programming; Making an online Address Book.\n" +
//                        "DATABASE DESIGN TOOLKIT (DBD): Coding Relational Schemas & Functional Dependencies; Invoking\n" +
//                        "SWI-Prolog Interpreter; DBD system predicates (xplus, finfplus, fplus, implies, equiv, superkey, candkey, mincover.\n" +
//                        "OBJECT-ORIENTED DATABASE MANAGEMENT SYSTEM (db4o): db4o Installation & Introduction; Simple\n" +
//                        "database creation exercise; Database updates & deletes; Database Querying (queryByExample, Native Queries, SODA\n" +
//                        "Queries); Company database application exercise; Web application exercise (client-server configuration).\n" +
//                        "XML DATABASE: XML basics; Creating a company database in XML; XML Editor (EditiX); XPath; XQuery;\n" +
//                        "FLWOR expressions; XML Schema\n");
//                //it4c2.put("Textbook", "");
//                it4c2.put("Reference", "Fundamentals of Database Systems: Laboratory Manual, R. Sunderraman\n" +
//                        "(http://tinman.cs.gsu.edu/~raj/elna-lab-2010/lab-manual.pdf).\n");
//                it4c2.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 4").document
//                        ("Database Management System Lab ").set(it4c2, SetOptions.merge());
//
//
//                // IT Semester 4 Operating Systems details
//                Map<String, Object> it4c3 = new HashMap<>();
//                it4c3.put("Course Contents", "Unit -I\n" +
//                        "Introduction: Operating system concepts, function, structure/layer of OS; evolution of OS, types of OS, system\n" +
//                        "protection.\n" +
//                        "Unit - II\n" +
//                        "Introduction to processes, concurrent processes, principle of concurrency, producer-consumer problem, semaphores,\n" +
//                        "classical problems in concurrency, inter processes communication, process generation, synchronization, process\n" +
//                        "scheduling, threads.\n" +
//                        "Unit - III\n" +
//                        "CPU scheduling: scheduling concept, performance criteria, scheduling algorithm evolution, multiprocessor\n" +
//                        "scheduling, deadlock- system model, deadlock characterization, prevention, recovery, avoidance and detection.\n" +
//                        "Unit - IV\n" +
//                        "Memory Management- single contiguous allocation; partitioned allocation; resident monitor, multiprogramming with\n" +
//                        "fixed partition, multiprogramming with variable partition, paging; virtual memory concepts; swapping; demand\n" +
//                        "paging; page replacement algorithms; segmentation; segmentation with paging; allocation of frames, thrashing, cache\n" +
//                        "memory organization.\n" +
//                        "Unit - V\n" +
//                        "I/O Management and Disk Scheduling - Principles of I/O hardware; I/O Devices, organization of I/O function, I/O\n" +
//                        "software, I/O buffering, disk I/O, disk scheduling algorithms. File System – files and directories, file organization\n" +
//                        "and access mechanism, file sharing, security; protection mechanism.\n" +
//                        "CASE STUDY: Linux – design principles; kernel modules; process management; scheduling; memory management;\n" +
//                        "file systems; input and output; IPC.\n");
//                it4c3.put("Textbook", "Operating Systems Concepts, 6th Ed, Silberschatz A, Galvin P, Gagne G, John Wiley & Sons, Singapore, 2006.\n");
//                it4c3.put("Reference Book", "1) Operating Systems, 3rd Ed, Deitel H M, Pearson Education, New Delhi, 2004.\n" +
//                        "2) Modern Operating System, 2nd Ed, Andrew S Tanenbaum, PHI, New Delhi, 2004.\n" +
//                        "3) Operating System Concepts (2/e), J. L. Peterson, Addison-Wesley, 1985.\n");
//                it4c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 4").document
//                        ("Operating Systems").set(it4c3, SetOptions.merge());
//
//
//                // IT Semester 4 Operating Systems Lab  details
//                Map<String, Object> it4c4 = new HashMap<>();
//                it4c4.put("Course Contents", "Lab and take home assignments based on the course “Operating Systems”.  \n");
//                //cs4c4.put("Textbook", "");
//                //cs4c4.put("Reference Book", "");
//                it4c4.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 4").document
//                        ("Operating Systems Lab").set(it4c4, SetOptions.merge());
//
//
//                // IT Semester 4 Operations Research details
//                Map<String, Object> it4c5 = new HashMap<>();
//                it4c5.put("Course Contents", "\uF0A7 Introduction to Operations Research (OR)\n" +
//                        "\uF0A7 Linear Programming (LP)\n" +
//                        "\uF0A7 Nonlinear programming\n" +
//                        "\uF0A7 Queuing\n" +
//                        "\uF0A7 Time-series analysis\n" +
//                        "\uF0A7 Dynamic programming\n" +
//                        "\uF0A7 Stochastic modeling and simulation\n" +
//                        "The course will discuss various theories and techniques for modeling real-world problems and methods to find their\n" +
//                        "optimal solutions.\n");
//                it4c5.put("Textbook", "1) Introduction to Operations Research, 7th. Ed. Frederick Hillier. McGraw-Hill, 2000.\n" +
//                        "2) Simulation Model Design and Execution, P. Fishwick. Prentice Hall, 1995.\n");
//                it4c5.put("Reference Book", "1) Operations Research: An Introduction (8/e). H. A. Taha, Prentice Hall, 2006.\n" +
//                        "2) Discrete-Event Simulation: Modeling, Programming and Analysis, George S. Fishman. Springer-Verlag, New York,\n" +
//                        "Inc., 2001.\n");
//                it4c5.put("Credits", "Lecture-3\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 4").document
//                        ("Operations Research").set(it4c5, SetOptions.merge());
//
//
//                // IT Semester 4 Science, Technology, Society details
//                Map<String, Object> it4c6 = new HashMap<>();
//                it4c6.put("Course Contents", "Module 1:\n" +
//                        "\uF0A7 Introduction to STS as a field of study and research in the twentieth century\n" +
//                        "\uF0A7 Philosophical, Historical and Sociological Approaches to Science and Technology and Society\n" +
//                        "\uF0A7 The growth and identity of Modern Science and Technology in India\n" +
//                        "Module 2: Science Communication- Institutions, ideologies, practices\n" +
//                        "\uF0A7 The diversity of science communication in colonial India\n" +
//                        "\uF0A7 Science communication and the Nehruvian Agenda\n" +
//                        "\uF0A7 The ideology and image of developmental science\n" +
//                        "\uF0A7 The agenda of People’s Science\n" +
//                        "\uF0A7 Liberalization and the commoditization of science and technology.\n");
//                it4c6.put("Textbook", "1) Science, Technology and Medicine in Colonial India – David Arnold (Cambridge,2004)\n" +
//                        "2) Western Science in Modern India, Metropolitan Methods, Colonial Practices – Pratik Chakrabarti, (Permanent\n" +
//                        "Black, 2004)\n");
//                it4c6.put("Reference Book", "A Concise History of Science in India – D. M. Bose, S. N. Sen, and B.V. Subarayappa (Universities Press, 2009)\n");
//                it4c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 4").document
//                        ("Science, Technology, Society").set(it4c6, SetOptions.merge());
//
//
//                // IT Semester 4 Technical Writing details
//                Map<String, Object> it4c7 = new HashMap<>();
//                it4c7.put("Course Contents", "Structure of sentences, paragraphs, and documents. using stress for emphasis, and sequencing topics to create forward\n" +
//                        "flow, writing for the reader; Formats of technical documents; the experimental report; the technical report, the\n" +
//                        "proposal; workshop on published documents; Discussion and workshop on term paper proposals; Graphics; emphasis\n" +
//                        "without distortion; visual illusions; a minimalist approach to data representation; univariate and multivariate displays;\n" +
//                        "Discussion and workshop on term papers; elements of oral presentations; oral presentations.\n");
//                it4c7.put("Textbook", "1) The Elements of Style, W. Strunk, E B White, New York: Macmillan, 1972.\n" +
//                        "2) The Mayfield Handbook of Technical and Scientific Writing, L. Perelman, Mayfield Publishing Company, 1998.\n" +
//                        "3) The Science of Scientific Writing, G. D. Gopen, J. A. Swan, American Scientist, 78(6):550-558, Nov-Dec 1990.\n");
//                //it4c7.put("Reference Book", "");
//                it4c7.put("Credits", "Lecture-1\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 4").document
//                        ("Technical Writing").set(it4c7, SetOptions.merge());
//
//
//
//
//                // IT Semester 5 Computer Networks details
//                Map<String, Object> it5c1 = new HashMap<>();
//                it5c1.put("Course Contents", "Unit -I\n" +
//                        "Introduction: Goals and Applications of Networks, Network structure and architecture, The OSI reference model,\n" +
//                        "services, Network Topology Design, Back Bone Design, Switching methods, ISDN, Terminal Handling. Physical\n" +
//                        "Layer - Transmission Media, transmission media; coaxial cable; fiber optics; line coding; modems; RS232 interfacing\n" +
//                        "sequences.\n" +
//                        "Unit-II\n" +
//                        "Data Link layer - Error detection and correction; parity; LRC; CRC; Hamming code; low control and error control;\n" +
//                        "stop and wait; go back-N ARQ; selective repeat ARQ; sliding window; HDLC; LAN; Ethernet; IEEE 802.3; IEEE\n" +
//                        "802.4; IEEE 802.5; IEEE 802.11; FDDI; SONET; Bridges.\n" +
//                        "Unit - III\n" +
//                        "Network layer - Internetworks; packet switching and datagram approach; IP addressing methods; subnetting; routing -\n" +
//                        "distance vector routing; link state routing; congestion control internetworking; security, IPv6.\n" +
//                        "Unit - IV\n" +
//                        "Transport layer - Basics of transport layer; multiplexing; demultiplexing; sockets; user datagram protocol (UDP);\n" +
//                        "transmission control protocol (TCP); congestion control; quality of services; integrated services, data compression\n" +
//                        "techniques, window management.\n" +
//                        "Unit-V\n" +
//                        "Application layer - Domain Name Space (DNS), File Transfer protocols, Electronic mail, SMTP, HTTP \n");
//
//                it5c1.put("Textbook", "1) Computer Networks, Andrew S. Tanenbaum, PHI, 2003.\n" +
//                        "2) Data and Computer Communication, W. Stallings, Pearson Education, 2000.\n");
//                it5c1.put("Reference Book", "1) Computer Networking: A Top-Down Approach Featuring the Internet, James F. Kurose and Keith W. Ross, Pearson\n" +
//                        "Education, 2003.\n" +
//                        "2) Computer Networks, Larry L. Peterson and Peter S. Davie, Elsevier.\n");
//                it5c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 5").document
//                        ("Computer Networks").set(cs5c1, SetOptions.merge());
//
//                // IT Semester 5 Computer Networks Lab details
//                Map<String, Object> it5c2 = new HashMap<>();
//                it5c2.put("Course Contents", "Lab assignments based on the course “Computer Networks”\n");
//
//                // it5c2.put("Textbook", "");
//                //it5c2.put("Reference Book", "");
//                it5c2.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-4\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 5").document
//                        ("Computer Networks Lab").set(it5c2, SetOptions.merge());
//
//
//                // IT Semester 5 Software Engineering details
//                Map<String, Object> it5c3 = new HashMap<>();
//                it5c3.put("Course Contents", "INTRODUCTION: The evolving role of software; software characteristics; software process - software process\n" +
//                        "models; linear sequential model; prototyping model; The RAD model; evolutionary software process models; The\n" +
//                        "incremental model; The spiral model.\n" +
//                        "SYSTEM ENGINEERING: Requirements analysis and negotiation; Requirements validation; Requirements\n" +
//                        "management.\n" +
//                        "ANALYSIS MODELING: Data modeling; data objects, attributes and relationships; cardinality and modality;\n" +
//                        "entity-relationship diagram; data flow diagrams; data dictionary.\n" +
//                        "DESIGN CONCEPTS AND PRINCIPLES: Software architecture; control hierarchy; structural partitioning; functional\n" +
//                        "Independence; cohesion, coupling; design documentation; architectural design; transform centered architecture;\n" +
//                        "transaction centered architecture; user Interface design models, user interface design process.\n" +
//                        "TESTING TECHNIQUES: Software testing fundamentals; test case design; White box testing; basis path testing;\n" +
//                        "control structure testing; Black box testing, testing for specialized environments, testing strategies; verification and\n" +
//                        "validation - unit testing, integration testing, validation testing, system testing, debugging.\n" +
//                        "SOFTWARE QUALITY ASSURANCE: Quality concepts; cost of quality, Software Quality Assurance (SQA) Group -\n" +
//                        "roles and responsibilities, formal technical reviews, quality standards.\n");
//                it5c3.put("Textbook", "Software Engineering – A Practitioner’s Approach, R. S. Pressman, McGraw Hill International Edition, Singapore,\n" +
//                        "2006.\n");
//                it5c3.put("Reference Book", "1) Software Engineering, I. Sommerville, Pearson Education, New Delhi, 2001.\n" +
//                        "2) An Integrated Approach to Software Engineering, P. Jalote, Narosa Publishers, New Delhi, 2005.\n");
//                it5c3.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 5").document
//                        ("Software Engineering").set(it5c3, SetOptions.merge());
//
//
//                // IT Semester 5 Web Technology details
//                Map<String, Object> it5c4 = new HashMap<>();
//                it5c4.put("Course Contents", "INTRODUCTION WEB SERVICES: Web services architecture; overview of web services; service oriented roles and\n" +
//                        "architecture; architectural process; three tier web based architecture.\n" +
//                        "XML: Introduction to XML; XML fundamentals; well-formed XML documents; components of XML document;\n" +
//                        "XML tools; XML style sheets; XSL; CSS; XML namespaces; EDI fact; message definition; segments; message\n" +
//                        "structure and electronic enveloping.\n" +
//                        "JAVA WEBSERVICES ARCHITECTURE: J2EE and web services-Introduction to JSP and java servlets; servlets;\n" +
//                        "overview of Java server pages.\n" +
//                        "ACTIVE SERVER PAGES: HTML and VBScript fundamentals; ASP concepts, using request, response, application,\n" +
//                        "session, server objects; cookies.\n" +
//                        ".NET FRAMEWORK: Overview of .NET framework; building blocks of .NET platform; role of .NET class libraries;\n" +
//                        "understanding CTS, CLR, CLS; deploying .NET; building C# applications.\n");
//                it5c4.put("Lab", " web technology tools, XML, SOAP, CORBA, RMI with emphasis on following:\n" +
//                        "PROJECT/ASSIGNMENT 1 (INFORMATION FLOW): Implementation of complete website; PHP backend; MySQL\n" +
//                        "Database; front-end Form development (text, email, radio, checkbox, select/data list)\n" +
//                        "PROJECT/ASSIGNMENT 2 (VALIDATION AND STRUCTURE): Client-side validation of project/assignment 1;\n" +
//                        "Server-side validation of project/assignment 1; Object-oriented designing of PHP backend (following MVC\n" +
//                        "architecture); Unit testing; Using Git; Using GitHub.\n" +
//                        "PROJECT/ASSIGNMENT 3 (SESSION MANAGEMENT): Session Management addition to project/assignment 2;\n" +
//                        "User login addition to project/assignment 2; Styling & Layout addition project/assignment 2.\n");
//                it5c4.put("Textbook", "Web Application Architecture: Principles, Protocols, & Practices, L. Shklar, R. Rosen\n");
//                it5c4.put("Reference Book", "1) Web Technologies: A Computer Science Perspective, Jeffrey Jackson\n" +
//                        "2) Web Technology: Theory and Practice, M. Srinivasan\n" +
//                        "3) Java Servlet Programming, J. Hunter, W. Crawford, O’Reilly Publications, USA, 1998.\n");
//                it5c4.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 5").document
//                        ("Web Technology").set(it5c4, SetOptions.merge());
//
//
//                // IT Semester 5 Information Security details
//                Map<String, Object> it5c5 = new HashMap<>();
//                it5c5.put("Course Contents", "INTRODUCTION: Computer Security, Threats to security, System Security; Viruses ,worms , Trojan horse, Intruders,\n" +
//                        "Malicious software, Firewalls,\n" +
//                        "CRYPTOGRAPHY BASICS: Classical, Symmetric and Asymmetric Cryptography, Modern ciphers, Hash functions,\n" +
//                        "Digital signature algorithms, Key management.\n" +
//                        "NETWORK SECURITY: Kerberos, SSL/TLS, E-Mail Security, IP security, Web security.\n" +
//                        "SECURITY CONTROLS & POLICIES: IDS/IPS, Access controls, Security policies, Standards, Ethics.\n");
//                it5c5.put("Textbook", "Computer Security: Art and Science, M. Bishop, Pearson Education, 2004.\n");
//                it5c5.put("Reference Book", "1) Network security, Kaufman, Perlman and Speciner, Pearson Education, 2002.\n" +
//                        "2) Cryptography and Network Security, W. Stallings, Prentice Hall, 2010.\n");
//                it5c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 5").document
//                        ("Information Security").set(it5c5, SetOptions.merge());
//
//
//                // IT Semester 5 Environmental Sciences details
//                Map<String, Object> it5c6 = new HashMap<>();
//                it5c6.put("Course Contents", "TBD [Taking clue from the curriculum of DA-IICT, Gandhinagar].");
//                //it5c6.put("Textbook", "");
//                //it5c6.put("Reference Book", "");
//                it5c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 5").document
//                        ("Environmental Sciences").set(it5c6, SetOptions.merge());
//
//
//
//                // IT Semester 5 Sciences Elective – 1 details
//                Map<String, Object> it5c7 = new HashMap<>();
//                //it5c7.put("Course Contents", "");
//                //it5c7.put("Textbook", "");
//                //it5c7.put("Reference Book", "");
//                it5c7.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 5").document
//                        ("Sciences Elective – 1 ").set(it5c7, SetOptions.merge());
//
//
//
//
//                // IT Semester 6 Software Project Management details
//                Map<String, Object> it6c1 = new HashMap<>();
//                it6c1.put("Course Contents", "INTRODUCTION: Introduction to project management; Open source tools, merits and limitations.\n" +
//                        "SOFTWARE MEASUREMENT: software metrics, cyclomatic complexity, class cohesion metrics.\n" +
//                        "SOFTWARE ESTIMATION: Cost estimation, effort estimation, schedule estimation, duration estimation.\n" +
//                        "SOFTWARE MANAGEMENT: Software planning; configuration management; software tendering and contracting\n" +
//                        "processes; risk management.\n" +
//                        "PROJECT EXECUTION AND QUALITY: Project execution; quality insurance, deadline management, configuration\n" +
//                        "management.\n" +
//                        "STANDARDS AND METHODOLOGIES: RFPs, IETF, ISO, IEEE standards.\n" +
//                        "WEB BASED OPEN SOURCE PROJECT MANAGEMENT TOOLS: Simulation/emulation, performance measures,\n" +
//                        "applications.\n");
//
//                it6c1.put("Textbook", "Software Project Management: A Process-Driven Approach -- A. Ahmed: Auerbach Publications, 2011\n");
//                it6c1.put("Reference Book", "Applied Software Project Management -- A. Stellman and J. Greene: O'Reilly Media, 2005.\n");
//                cs6c1.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 6").document
//                        ("Software Project Management").set(it6c1, SetOptions.merge());
//
//
//
//                // IT Semester 6 Human Computer Interaction details
//                Map<String, Object> it6c2 = new HashMap<>();
//                it6c2.put("Course Contents", "HCI foundation and history; Usability life cycle and methods; Design rules and guidelines; Empirical research\n" +
//                        "methods; Models in HCI - GOMS, Fitts’ law and Hick-Hyman’s law; Task analysis; Dialogue design; Cognitive\n" +
//                        "architecture and HCI ; Graphic User Interfaces & aesthetics; Usability Testing; UML,OOP,OOM; Design Case\n" +
//                        "Studies.\n ");
//                it6c2.put("Textbook", "Human Computer Interaction, A. Dix, J. Finlay, G. D. Abowd, R. Beale, Pearson Education, 2005.\n");
//                it6c2.put("Reference Book", "1) Human Computer Interaction, J. Preece, Y. Rogers, H. Sharp, D. Baniyon, S. Holland, T. Carey, Addison-Wesley,\n" +
//                        "1994.\n" +
//                        "2) Designing the User Interface, B. Shneiderman, Addison Wesley, 2000.\n");
//                it6c2.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 6").document
//                        ("Human Computer Interaction").set(it6c2, SetOptions.merge());
//
//
//                // IT Semester 6 Human Computer Interaction Lab details
//                Map<String, Object> it6c3 = new HashMap<>();
//                it5c6.put("Course Contents", "Lab assignments based on the course “HCI”. Following topics/assignments should get consideration:\n" +
//                        "Explain technology in interface Design; explain the user interface design process; coloring guidelines; Speech\n" +
//                        "Recognition and speech generation; Types of windows; Components of UI, such as Text Boxes, List Boxes, Messages,\n" +
//                        "Icons, Multimedia; Mental models; Importance of the mental models in UI design.\n" +
//                        "A project with a team of minimum 2 and maximum 3 students. The purpose of the project is focused on User\n" +
//                        "interaction and NOT on the implementation of the entire project. The partial list of projects could be:\n" +
//                        "\uF0A7 Online shopping website.\n" +
//                        "\uF0A7 e learning web site\n" +
//                        "\uF0A7 Video/ Audio on demand web site\n" +
//                        "\uF0A7 ATM interface\n" +
//                        "\uF0A7 Travel reservation system\n" +
//                        "\uF0A7 Students’ Kiosk for institute’s information \n" +
//                        "\uF0A7 Online trading on Stock market\n" +
//                        "\uF0A7 University web site\n" +
//                        "\uF0A7 Hospital Management\n" +
//                        "\uF0A7 Placement agency");
//                //it6c3.put("Textbook", "");
//                //it6c3.put("Reference Book", "");
//                it6c3.put("Credits", "Lecture-0\n" + "Tutorial-1\n" + "Practical-2\n" + "Total-2");
//
//                db.collection("BTECH").document("IT").collection("Semester 6").document
//                        ("Human Computer Interaction Lab ").set(it6c3, SetOptions.merge());
//
//
//                // IT Semester 6 Introduction Information Retrieval details
//                Map<String, Object> it6c4 = new HashMap<>();
//                it6c4.put("Course Contents", "Goals and history of IR, Vector-space retrieval model, Language model, Text tokenization, Stemming, Relevance\n" +
//                        "feedback, Query expansion; Ontology,\n" +
//                        "Text entities, Part of Speech tagging, Named Entity Recognition, Word Sense Disambiguation, Language dependent\n" +
//                        "modules for Indexing, IR in linguistic resource constrained situation, Statistical stemming, Dictionary construction,\n" +
//                        "Document alignment, Passage retrieval, Question Answering, Domain specific QA, Text categorization, clustering,\n" +
//                        "summarization, Creation of test cases, Performance metrics: recall, precision, bpref, Evaluations on benchmark text\n" +
//                        "collections form TREC, CLEF, NTCIR, FIRE\n");
//                it6c4.put("Textbook", "1) Introduction to Information Retrieval, C. D. Manning, P. Raghavan and H. Schütze, Cambridge University Press.\n" +
//                        "2008.\n" +
//                        "2) Modern Information Retrieval, R. Baeza-Yates, and B. Ribeiro-Neto, Addison Wesley Longman Publishing Co. Inc.\n" +
//                        "1999\n");
//                //it6c4.put("Reference Book", "");
//                it6c4.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 6").document
//                        ("Introduction to Information Retrieval").set(it6c4, SetOptions.merge());
//
//
//                // IT Semester 6 E-Commerce  details
//                Map<String, Object> it6c5 = new HashMap<>();
//                it6c5.put("Course Contents", "Introduction to Electronic Commerce; WWW; Buyer-seller model; Marketing on the web; B2B strategies; B2C\n" +
//                        "strategies; M2M business; Web portals; Online auctions; EC software, hardware; Payment systems; Web 2.0; EC\n" +
//                        "security.\n");
//                it6c5.put("Textbook", "1) Electronic Commerce (9/e). G. Schneider, Cengage Learning, 2010.\n" +
//                        "2) eBusiness & eCommerce - How to Program. Deitel, Deitel & Nieto, Prentice Hall, 2001.\n");
//                //it6c5.put("Reference Book", "");
//                it6c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 6").document
//                        ("E-Commerce ").set(it6c5, SetOptions.merge());
//
//
//                // IT Semester 6 Technical Elective - 1 details
//                Map<String, Object> it6c6 = new HashMap<>();
//                //it6c6.put("Course Contents", "");
//                //it6c6.put("Textbook", "");
//                //it6c6.put("Reference Book", "");
//                it6c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 6").document
//                        ("Technical Elective - 1").set(it5c6, SetOptions.merge());
//
//
//                // IT Semester 6 Humanities Elective – 1 details
//                Map<String, Object> it6c7 = new HashMap<>();
//                //it6c7.put("Course Contents", "");
//                //it6c7.put("Textbook", "");
//                //it6c7.put("Reference Book", "");
//                it6c7.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 6").document
//                        ("Humanities Elective – 1").set(it6c7, SetOptions.merge());
//
//
//
//                // IT Semester 7 Professional Ethics details
//                Map<String, Object> it7c1 = new HashMap<>();
//                it7c1.put("Course Contents", "HUMAN VALUES: Morals, values and ethics, integrity; service learning; civic virtue; respect for others; sharing;\n" +
//                        "honesty; courage; valuing time; cooperation; commitment; empathy; self-confidence; spirituality.\n" +
//                        "ENGINEERING ETHICS: Senses of Engineering Ethics; moral dilemmas, moral autonomy; Kohlberg’s theory;\n" +
//                        "Gilligan’s theory; consensus and controversy; models of professional roles; theories about right action; self-interest;\n" +
//                        "customs and religion; uses of ethical theories.\n" +
//                        "ENGINEERING AS SOCIAL EXPERIMENTATION: Engineers as responsible experimenters; codes of ethics; case\n" +
//                        "study.\n" +
//                        "SAFETY, RESPONSIBILITIES AND RIGHTS: Safety and risk; assessment of safety and risk; risk benefit analysis\n" +
//                        "and reducing risk; the three mile island and chernobyl case studies.\n" +
//                        "COLLEGIALITY AND LOYALTY: Respect for authority; collective bargaining; confidentiality; conflicts of interest;\n" +
//                        "occupational crime; professional rights; employee rights; Intellectual Property Rights (IPR); discrimination.\n" +
//                        "GLOBAL ISSUES: Multinational corporations; environmental ethics; computer ethics; weapons development;\n" +
//                        "engineers as managers; consulting engineers; engineers as expert witnesses and advisors; moral leadership; sample\n" +
//                        "code of ethics like ASME, ASCE, IEEE, IE (India), IETE (India).\n");
//                it7c1.put("Textbook", "Engineering Ethics, C. D. Fleddermann, Pearson Education/ Prentice Hall, New Jersey, 2004.\n");
//                it7c1.put("Reference Book", "1) Ethics in engineering, M. Martin, R. Schinzinger, McGraw-Hill, New York1996.\n" +
//                        "2) Engineering Ethics – Concepts and Cases, C. E. Harris, M. S. Pritchard, M. J Rabins, Thomson Learning, United\n" +
//                        "States, 2000.\n");
//                it7c1.put("Credits", "Lecture-2\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-2");
//
//                db.collection("BTECH").document("IT").collection("Semester 7").document
//                        ("Professional Ethics ").set(it7c1, SetOptions.merge());
//
//
//                // IT Semester 7 Management Information Systems details
//                Map<String, Object> it7c2 = new HashMap<>();
//
//                it7c2.put("Course Contents", "INTRODUCTION: Technology of Information Systems, concepts, definition; role and impact of MIS; role and\n" +
//                        "importance of management; approaches to management; functions of the manager; management as a control system;\n" +
//                        "concepts of data models; database design; client-server architecture.\n" +
//                        "PROCESS OF MANAGEMENT: Planning, organization, staffing, coordination and controlling; management by\n" +
//                        "exception; MIS as a support to management; organization structure and theory; basic model and organization\n" +
//                        "structure; organizational behavior.\n" +
//                        "DECSION MAKING AND INFORMATION: Decision making concepts, methods, tools and procedures; behavioral\n" +
//                        "concepts in decision making; organizational decision making; information concepts as a quality product; classification\n" +
//                        "of the information; methods of data and information collection; value of the information; organization and information\n" +
//                        "system concepts, control types; handling system complexity; post implementation problems in systems.\n" +
//                        "SYSTEM ANALYSIS AND DESIGN: Need for system analysis; system analysis of existing system; new\n" +
//                        "requirement; system development model; structured system analysis and design; computer system design;\n" +
//                        "development of MIS; development of long range plans of the MIS; ascertaining the class of the information;\n" +
//                        "determining the information requirement; development and implementation of the MIS; management of quality; MIS\n" +
//                        "factors of success and failure.\n" +
//                        "DECISION SUPPORT SYSTEMS: Deterministic systems; artificial intelligence; knowledge based systems; MIS and\n" +
//                        "the role of DSS; enterprise management systems; enterprise resource planning (ERP); ERP features and benefits;\n" +
//                        "implementation factors of ERP; Internet and Web based information system; Electronic Commerce.\n");
//                it7c2.put("Textbook", "Management Information Systems, K. C Landon, J. P..Laudon, Prentice Hall, 2000.\n");
//                it7c2.put("Reference Book", "Management Information Systems, G. B. Davis, M. H. Olson, McGraw Hill,1998.\n");
//                it7c2.put("Credits", "Lecture-2\n" + "Tutorial-1\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 7").document
//                        ("Management Information Systems").set(it7c2, SetOptions.merge());
//
//
//
//                // IT Semester 7 System Administration and Maintenance details
//                Map<String, Object> it7c3 = new HashMap<>();
//                it7c3.put("Course Contents", "Desktops, servers, Operating System Installation & Configuration; booting; hardening; processes (Server Processes,\n" +
//                        "Client Processes); File System Organization; Network Services (HTTP, LPR, NFS, SMTP, SSH, etc.); System Support\n" +
//                        "and Maintenance; Application Installation & Configuration; Application Support & Maintenance; Server\n" +
//                        "Administration & Management; User and Group Management; Backup & Disaster Recovery; Security Management;\n" +
//                        "Job Scheduling & Automation; Resource and Site Management; Performance Monitoring; User Support and\n" +
//                        "Education; helpdesk; policies; ethics.\n");
//                it7c3.put("Textbook", "UNIX and Linux System Administration Handbook, Nemeth, Snyder, Hein and Whaley, Prentice Hall, 2010.\n");
//                it7c3.put("Reference Book", "The Practice of System and Network Administration, Limoncelli, Hogan and Chalup, Addison Wesley, 2007.\n");
//                it7c3.put("Credits", "Lecture-2\n" + "Tutorial-0\n" + "Practical-4\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 7").document
//                        ("System Administration and Maintenance").set(it7c3, SetOptions.merge());
//
//
//
//                // IT Semester 7 Technical Elective – 2 details
//                Map<String, Object> it7c4 = new HashMap<>();
//                //it7c4.put("Course Contents", "");
//                //it7c4.put("Textbook", "");
//                //it7c4.put("Reference Book", "");
//                it7c4.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-2\n" + "Total-4");
//
//                db.collection("BTECH").document("IT").collection("Semester 7").document
//                        ("Technical Elective – 2").set(it7c4, SetOptions.merge());
//
//
//
//                // IT Semester 7 Technical Elective – 3 details
//                Map<String, Object> it7c5 = new HashMap<>();
//                //it7c5.put("Course Contents", "");
//                //it7c5.put("Textbook", "");
//                //it7c5.put("Reference Book", "");
//                it7c5.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 7").document
//                        ("Technical Elective – 3 ").set(it7c5, SetOptions.merge());
//
//
//
//                // IT Semester 7 Technical Elective – 4 details
//                Map<String, Object> it7c6 = new HashMap<>();
//                //it7c6.put("Course Contents", "");
//                //it7c6.put("Textbook", "");
//                //it7c6.put("Reference Book", "");
//                it7c6.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 7").document
//                        ("Technical Elective – 4 ").set(it7c6, SetOptions.merge());
//
//
//
//                // IT Semester 7 Science Elective – 2 details
//                Map<String, Object> it7c7 = new HashMap<>();
//                //it7c7.put("Course Contents", "");
//                //it7c7.put("Textbook", "");
//                //it7c7.put("Reference Book", "");
//                it7c7.put("Credits", "Lecture-3\n" + "Tutorial-0\n" + "Practical-0\n" + "Total-3");
//
//                db.collection("BTECH").document("IT").collection("Semester 7").document
//                        ("Science Elective – 2 ").set(it7c7, SetOptions.merge());
//
//
//
//                // IT Semester 8 Project details
//                Map<String, Object> it8p = new HashMap<>();
//                it8p.put("Description", "Final semester project is a guided project. Students can take individual project or group project. In case it is a group\n" +
//                        "project the size of the group would be restricted to not more than two students. Students would be allowed to\n" +
//                        "undertake their final semester project outside the Institute. Students can undertake such projects in any other\n" +
//                        "educational institute or in a research lab. Students would also be allowed to join industry for this final semester project\n" +
//                        "in case the nature of the project is based on some research.\n");
//                //it8p.put("Textbook", "");
//                //it8p.put("Reference Book", "");
//                it8p.put("Credits", "Lecture-0\n" + "Tutorial-0\n" + "Practical-36\n" + "Total-18");
//
//                db.collection("BTECH").document("IT").collection("Semester 8").document
//                        ("Project").set(it8p, SetOptions.merge());
//
//
//
//                // IT Summer 1 Design Project details
//                Map<String, Object> itsdp1 = new HashMap<>();
//                //itsdp1.put("Description", "");
//                //itsdp1.put("Textbook", "");
//                //itsdp1.put("Reference Book", "");
//                itsdp1.put("Credits", "Pass/Fail");
//
//                db.collection("BTECH").document("IT").collection("Summer 1").document
//                        ("Design Project").set(itsdp1, SetOptions.merge());
//
//
//
//                // IT Summer 2 Design Project details
//                Map<String, Object> itsdp2 = new HashMap<>();
//                //itsdp2.put("Description", "");
//                //itsdp2.put("Textbook", "");
//                //itsdp2.put("Reference Book", "");
//                itsdp2.put("Credits", "Pass/Fail");
//
//                db.collection("BTECH").document("IT").collection("Summer 2").document
//                        ("Design Project").set(itsdp2, SetOptions.merge());

//(



    }
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return adt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void goTo1(MenuItem item) {
        goToUrl ( "http://iiitvadodara.ac.in/pdf/Holiday%20List%202019.pdf");
    }
    //acc cal
    public void goTo2(MenuItem item) {
        goToUrl ("http://iiitvadodara.ac.in/pdf/Academic%20Calendar%20Autumn%202018-19.pdf");
    }
    // academic regulations
    public void goTo3(MenuItem item) {
        goToUrl ("http://iiitvadodara.ac.in/pdf/IIITV-Regulations-2018.pdf");
    }
   public void about(MenuItem item) {
        Intent intent = new Intent (MainActivity.this,AboutActivity.class);
        startActivity (intent);
    }
}
