/// Response models for the Liturgical Calendar API.

/// API Response wrapper.
class LiturgicalcalendarResponse {
  final String status;
  final dynamic error;
  final LiturgicalcalendarData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  LiturgicalcalendarResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory LiturgicalcalendarResponse.fromJson(Map<String, dynamic> json) => LiturgicalcalendarResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? LiturgicalcalendarData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Liturgical Calendar API.

class LiturgicalcalendarData {
  List<LiturgicalcalendarData20260101Item>? 2026-01-01;
  List<LiturgicalcalendarData20260102Item>? 2026-01-02;
  List<LiturgicalcalendarData20260103Item>? 2026-01-03;
  List<LiturgicalcalendarData20260104Item>? 2026-01-04;
  List<LiturgicalcalendarData20260105Item>? 2026-01-05;
  List<LiturgicalcalendarData20260106Item>? 2026-01-06;
  List<LiturgicalcalendarData20260107Item>? 2026-01-07;
  List<LiturgicalcalendarData20260108Item>? 2026-01-08;
  List<LiturgicalcalendarData20260109Item>? 2026-01-09;
  List<LiturgicalcalendarData20260110Item>? 2026-01-10;
  List<LiturgicalcalendarData20260111Item>? 2026-01-11;
  List<LiturgicalcalendarData20260112Item>? 2026-01-12;
  List<LiturgicalcalendarData20260113Item>? 2026-01-13;
  List<LiturgicalcalendarData20260114Item>? 2026-01-14;
  List<LiturgicalcalendarData20260115Item>? 2026-01-15;
  List<LiturgicalcalendarData20260116Item>? 2026-01-16;
  List<LiturgicalcalendarData20260117Item>? 2026-01-17;
  List<LiturgicalcalendarData20260118Item>? 2026-01-18;
  List<LiturgicalcalendarData20260119Item>? 2026-01-19;
  List<LiturgicalcalendarData20260120Item>? 2026-01-20;
  List<LiturgicalcalendarData20260121Item>? 2026-01-21;
  List<LiturgicalcalendarData20260122Item>? 2026-01-22;
  List<LiturgicalcalendarData20260123Item>? 2026-01-23;
  List<LiturgicalcalendarData20260124Item>? 2026-01-24;
  List<LiturgicalcalendarData20260125Item>? 2026-01-25;
  List<LiturgicalcalendarData20260126Item>? 2026-01-26;
  List<LiturgicalcalendarData20260127Item>? 2026-01-27;
  List<LiturgicalcalendarData20260128Item>? 2026-01-28;
  List<LiturgicalcalendarData20260129Item>? 2026-01-29;
  List<LiturgicalcalendarData20260130Item>? 2026-01-30;
  List<LiturgicalcalendarData20260131Item>? 2026-01-31;

  LiturgicalcalendarData({
    this.2026-01-01,
    this.2026-01-02,
    this.2026-01-03,
    this.2026-01-04,
    this.2026-01-05,
    this.2026-01-06,
    this.2026-01-07,
    this.2026-01-08,
    this.2026-01-09,
    this.2026-01-10,
    this.2026-01-11,
    this.2026-01-12,
    this.2026-01-13,
    this.2026-01-14,
    this.2026-01-15,
    this.2026-01-16,
    this.2026-01-17,
    this.2026-01-18,
    this.2026-01-19,
    this.2026-01-20,
    this.2026-01-21,
    this.2026-01-22,
    this.2026-01-23,
    this.2026-01-24,
    this.2026-01-25,
    this.2026-01-26,
    this.2026-01-27,
    this.2026-01-28,
    this.2026-01-29,
    this.2026-01-30,
    this.2026-01-31,
  });

  factory LiturgicalcalendarData.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData(
      2026-01-01: (json['2026-01-01'] as List?)?.map((e) => LiturgicalcalendarData20260101Item.fromJson(e)).toList(),
      2026-01-02: (json['2026-01-02'] as List?)?.map((e) => LiturgicalcalendarData20260102Item.fromJson(e)).toList(),
      2026-01-03: (json['2026-01-03'] as List?)?.map((e) => LiturgicalcalendarData20260103Item.fromJson(e)).toList(),
      2026-01-04: (json['2026-01-04'] as List?)?.map((e) => LiturgicalcalendarData20260104Item.fromJson(e)).toList(),
      2026-01-05: (json['2026-01-05'] as List?)?.map((e) => LiturgicalcalendarData20260105Item.fromJson(e)).toList(),
      2026-01-06: (json['2026-01-06'] as List?)?.map((e) => LiturgicalcalendarData20260106Item.fromJson(e)).toList(),
      2026-01-07: (json['2026-01-07'] as List?)?.map((e) => LiturgicalcalendarData20260107Item.fromJson(e)).toList(),
      2026-01-08: (json['2026-01-08'] as List?)?.map((e) => LiturgicalcalendarData20260108Item.fromJson(e)).toList(),
      2026-01-09: (json['2026-01-09'] as List?)?.map((e) => LiturgicalcalendarData20260109Item.fromJson(e)).toList(),
      2026-01-10: (json['2026-01-10'] as List?)?.map((e) => LiturgicalcalendarData20260110Item.fromJson(e)).toList(),
      2026-01-11: (json['2026-01-11'] as List?)?.map((e) => LiturgicalcalendarData20260111Item.fromJson(e)).toList(),
      2026-01-12: (json['2026-01-12'] as List?)?.map((e) => LiturgicalcalendarData20260112Item.fromJson(e)).toList(),
      2026-01-13: (json['2026-01-13'] as List?)?.map((e) => LiturgicalcalendarData20260113Item.fromJson(e)).toList(),
      2026-01-14: (json['2026-01-14'] as List?)?.map((e) => LiturgicalcalendarData20260114Item.fromJson(e)).toList(),
      2026-01-15: (json['2026-01-15'] as List?)?.map((e) => LiturgicalcalendarData20260115Item.fromJson(e)).toList(),
      2026-01-16: (json['2026-01-16'] as List?)?.map((e) => LiturgicalcalendarData20260116Item.fromJson(e)).toList(),
      2026-01-17: (json['2026-01-17'] as List?)?.map((e) => LiturgicalcalendarData20260117Item.fromJson(e)).toList(),
      2026-01-18: (json['2026-01-18'] as List?)?.map((e) => LiturgicalcalendarData20260118Item.fromJson(e)).toList(),
      2026-01-19: (json['2026-01-19'] as List?)?.map((e) => LiturgicalcalendarData20260119Item.fromJson(e)).toList(),
      2026-01-20: (json['2026-01-20'] as List?)?.map((e) => LiturgicalcalendarData20260120Item.fromJson(e)).toList(),
      2026-01-21: (json['2026-01-21'] as List?)?.map((e) => LiturgicalcalendarData20260121Item.fromJson(e)).toList(),
      2026-01-22: (json['2026-01-22'] as List?)?.map((e) => LiturgicalcalendarData20260122Item.fromJson(e)).toList(),
      2026-01-23: (json['2026-01-23'] as List?)?.map((e) => LiturgicalcalendarData20260123Item.fromJson(e)).toList(),
      2026-01-24: (json['2026-01-24'] as List?)?.map((e) => LiturgicalcalendarData20260124Item.fromJson(e)).toList(),
      2026-01-25: (json['2026-01-25'] as List?)?.map((e) => LiturgicalcalendarData20260125Item.fromJson(e)).toList(),
      2026-01-26: (json['2026-01-26'] as List?)?.map((e) => LiturgicalcalendarData20260126Item.fromJson(e)).toList(),
      2026-01-27: (json['2026-01-27'] as List?)?.map((e) => LiturgicalcalendarData20260127Item.fromJson(e)).toList(),
      2026-01-28: (json['2026-01-28'] as List?)?.map((e) => LiturgicalcalendarData20260128Item.fromJson(e)).toList(),
      2026-01-29: (json['2026-01-29'] as List?)?.map((e) => LiturgicalcalendarData20260129Item.fromJson(e)).toList(),
      2026-01-30: (json['2026-01-30'] as List?)?.map((e) => LiturgicalcalendarData20260130Item.fromJson(e)).toList(),
      2026-01-31: (json['2026-01-31'] as List?)?.map((e) => LiturgicalcalendarData20260131Item.fromJson(e)).toList(),
    );
}

class LiturgicalcalendarData20260101Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260101Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260101Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260101Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260102Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;
  LiturgicalcalendarData20260102ItemWeekday? weekday;

  LiturgicalcalendarData20260102Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
    this.weekday,
  });

  factory LiturgicalcalendarData20260102Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260102Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
      weekday: json['weekday'] != null ? LiturgicalcalendarData20260102ItemWeekday.fromJson(json['weekday']) : null,
    );
}

class LiturgicalcalendarData20260102ItemWeekday {
  String? id;
  String? date;
  LiturgicalcalendarData20260102ItemWeekdayDatedef? dateDef;
  List<dynamic>? dateExceptions;
  List<dynamic>? alternativeTransferDateDefs;
  String? precedence;
  String? rank;
  bool? allowSimilarRankItems;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? i18nDef;
  List<String>? seasons;
  List<String>? periods;
  List<String>? colors;
  List<dynamic>? commonsDef;
  List<dynamic>? martyrology;
  List<dynamic>? titles;
  LiturgicalcalendarData20260102ItemWeekdayCalendar? calendar;
  LiturgicalcalendarData20260102ItemWeekdayCycles? cycles;
  String? fromCalendarId;
  List<dynamic>? fromExtendedCalendars;

  LiturgicalcalendarData20260102ItemWeekday({
    this.id,
    this.date,
    this.dateDef,
    this.dateExceptions,
    this.alternativeTransferDateDefs,
    this.precedence,
    this.rank,
    this.allowSimilarRankItems,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.i18nDef,
    this.seasons,
    this.periods,
    this.colors,
    this.commonsDef,
    this.martyrology,
    this.titles,
    this.calendar,
    this.cycles,
    this.fromCalendarId,
    this.fromExtendedCalendars,
  });

  factory LiturgicalcalendarData20260102ItemWeekday.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260102ItemWeekday(
      id: json['id'],
      date: json['date'],
      dateDef: json['dateDef'] != null ? LiturgicalcalendarData20260102ItemWeekdayDatedef.fromJson(json['dateDef']) : null,
      dateExceptions: (json['dateExceptions'] as List?)?.cast<dynamic>(),
      alternativeTransferDateDefs: (json['alternativeTransferDateDefs'] as List?)?.cast<dynamic>(),
      precedence: json['precedence'],
      rank: json['rank'],
      allowSimilarRankItems: json['allowSimilarRankItems'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      i18nDef: (json['i18nDef'] as List?)?.cast<String>(),
      seasons: (json['seasons'] as List?)?.cast<String>(),
      periods: (json['periods'] as List?)?.cast<String>(),
      colors: (json['colors'] as List?)?.cast<String>(),
      commonsDef: (json['commonsDef'] as List?)?.cast<dynamic>(),
      martyrology: (json['martyrology'] as List?)?.cast<dynamic>(),
      titles: (json['titles'] as List?)?.cast<dynamic>(),
      calendar: json['calendar'] != null ? LiturgicalcalendarData20260102ItemWeekdayCalendar.fromJson(json['calendar']) : null,
      cycles: json['cycles'] != null ? LiturgicalcalendarData20260102ItemWeekdayCycles.fromJson(json['cycles']) : null,
      fromCalendarId: json['fromCalendarId'],
      fromExtendedCalendars: (json['fromExtendedCalendars'] as List?)?.cast<dynamic>(),
    );
}

class LiturgicalcalendarData20260102ItemWeekdayDatedef {
  String? dateFn;
  List<num>? dateArgs;
  num? yearOffset;

  LiturgicalcalendarData20260102ItemWeekdayDatedef({
    this.dateFn,
    this.dateArgs,
    this.yearOffset,
  });

  factory LiturgicalcalendarData20260102ItemWeekdayDatedef.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260102ItemWeekdayDatedef(
      dateFn: json['dateFn'],
      dateArgs: (json['dateArgs'] as List?)?.cast<num>(),
      yearOffset: json['yearOffset'],
    );
}

class LiturgicalcalendarData20260102ItemWeekdayCalendar {
  num? weekOfSeason;
  num? dayOfSeason;
  num? dayOfWeek;
  num? nthDayOfWeekInMonth;
  String? startOfSeason;
  String? endOfSeason;
  String? startOfLiturgicalYear;
  String? endOfLiturgicalYear;
  List<String>? seasons;

  LiturgicalcalendarData20260102ItemWeekdayCalendar({
    this.weekOfSeason,
    this.dayOfSeason,
    this.dayOfWeek,
    this.nthDayOfWeekInMonth,
    this.startOfSeason,
    this.endOfSeason,
    this.startOfLiturgicalYear,
    this.endOfLiturgicalYear,
    this.seasons,
  });

  factory LiturgicalcalendarData20260102ItemWeekdayCalendar.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260102ItemWeekdayCalendar(
      weekOfSeason: json['weekOfSeason'],
      dayOfSeason: json['dayOfSeason'],
      dayOfWeek: json['dayOfWeek'],
      nthDayOfWeekInMonth: json['nthDayOfWeekInMonth'],
      startOfSeason: json['startOfSeason'],
      endOfSeason: json['endOfSeason'],
      startOfLiturgicalYear: json['startOfLiturgicalYear'],
      endOfLiturgicalYear: json['endOfLiturgicalYear'],
      seasons: (json['seasons'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260102ItemWeekdayCycles {
  String? properCycle;
  String? sundayCycle;
  String? weekdayCycle;
  String? psalterWeek;

  LiturgicalcalendarData20260102ItemWeekdayCycles({
    this.properCycle,
    this.sundayCycle,
    this.weekdayCycle,
    this.psalterWeek,
  });

  factory LiturgicalcalendarData20260102ItemWeekdayCycles.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260102ItemWeekdayCycles(
      properCycle: json['properCycle'],
      sundayCycle: json['sundayCycle'],
      weekdayCycle: json['weekdayCycle'],
      psalterWeek: json['psalterWeek'],
    );
}

class LiturgicalcalendarData20260103Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260103Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260103Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260103Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260104Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260104Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260104Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260104Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260105Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260105Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260105Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260105Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260106Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260106Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260106Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260106Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260107Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260107Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260107Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260107Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260108Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260108Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260108Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260108Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260109Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260109Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260109Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260109Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260110Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260110Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260110Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260110Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260111Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260111Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260111Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260111Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260112Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260112Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260112Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260112Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260113Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260113Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260113Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260113Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260114Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260114Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260114Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260114Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260115Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260115Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260115Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260115Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260116Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260116Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260116Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260116Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260117Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;
  LiturgicalcalendarData20260117ItemWeekday? weekday;

  LiturgicalcalendarData20260117Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
    this.weekday,
  });

  factory LiturgicalcalendarData20260117Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260117Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
      weekday: json['weekday'] != null ? LiturgicalcalendarData20260117ItemWeekday.fromJson(json['weekday']) : null,
    );
}

class LiturgicalcalendarData20260117ItemWeekday {
  String? id;
  String? date;
  LiturgicalcalendarData20260117ItemWeekdayDatedef? dateDef;
  List<dynamic>? dateExceptions;
  List<dynamic>? alternativeTransferDateDefs;
  String? precedence;
  String? rank;
  bool? allowSimilarRankItems;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? i18nDef;
  List<String>? seasons;
  List<String>? periods;
  List<String>? colors;
  List<dynamic>? commonsDef;
  List<dynamic>? martyrology;
  List<dynamic>? titles;
  LiturgicalcalendarData20260117ItemWeekdayCalendar? calendar;
  LiturgicalcalendarData20260117ItemWeekdayCycles? cycles;
  String? fromCalendarId;
  List<dynamic>? fromExtendedCalendars;

  LiturgicalcalendarData20260117ItemWeekday({
    this.id,
    this.date,
    this.dateDef,
    this.dateExceptions,
    this.alternativeTransferDateDefs,
    this.precedence,
    this.rank,
    this.allowSimilarRankItems,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.i18nDef,
    this.seasons,
    this.periods,
    this.colors,
    this.commonsDef,
    this.martyrology,
    this.titles,
    this.calendar,
    this.cycles,
    this.fromCalendarId,
    this.fromExtendedCalendars,
  });

  factory LiturgicalcalendarData20260117ItemWeekday.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260117ItemWeekday(
      id: json['id'],
      date: json['date'],
      dateDef: json['dateDef'] != null ? LiturgicalcalendarData20260117ItemWeekdayDatedef.fromJson(json['dateDef']) : null,
      dateExceptions: (json['dateExceptions'] as List?)?.cast<dynamic>(),
      alternativeTransferDateDefs: (json['alternativeTransferDateDefs'] as List?)?.cast<dynamic>(),
      precedence: json['precedence'],
      rank: json['rank'],
      allowSimilarRankItems: json['allowSimilarRankItems'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      i18nDef: (json['i18nDef'] as List?)?.cast<String>(),
      seasons: (json['seasons'] as List?)?.cast<String>(),
      periods: (json['periods'] as List?)?.cast<String>(),
      colors: (json['colors'] as List?)?.cast<String>(),
      commonsDef: (json['commonsDef'] as List?)?.cast<dynamic>(),
      martyrology: (json['martyrology'] as List?)?.cast<dynamic>(),
      titles: (json['titles'] as List?)?.cast<dynamic>(),
      calendar: json['calendar'] != null ? LiturgicalcalendarData20260117ItemWeekdayCalendar.fromJson(json['calendar']) : null,
      cycles: json['cycles'] != null ? LiturgicalcalendarData20260117ItemWeekdayCycles.fromJson(json['cycles']) : null,
      fromCalendarId: json['fromCalendarId'],
      fromExtendedCalendars: (json['fromExtendedCalendars'] as List?)?.cast<dynamic>(),
    );
}

class LiturgicalcalendarData20260117ItemWeekdayDatedef {
  String? dateFn;
  List<num>? dateArgs;
  num? yearOffset;

  LiturgicalcalendarData20260117ItemWeekdayDatedef({
    this.dateFn,
    this.dateArgs,
    this.yearOffset,
  });

  factory LiturgicalcalendarData20260117ItemWeekdayDatedef.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260117ItemWeekdayDatedef(
      dateFn: json['dateFn'],
      dateArgs: (json['dateArgs'] as List?)?.cast<num>(),
      yearOffset: json['yearOffset'],
    );
}

class LiturgicalcalendarData20260117ItemWeekdayCalendar {
  num? weekOfSeason;
  num? dayOfSeason;
  num? dayOfWeek;
  num? nthDayOfWeekInMonth;
  String? startOfSeason;
  String? endOfSeason;
  String? startOfLiturgicalYear;
  String? endOfLiturgicalYear;
  List<String>? seasons;

  LiturgicalcalendarData20260117ItemWeekdayCalendar({
    this.weekOfSeason,
    this.dayOfSeason,
    this.dayOfWeek,
    this.nthDayOfWeekInMonth,
    this.startOfSeason,
    this.endOfSeason,
    this.startOfLiturgicalYear,
    this.endOfLiturgicalYear,
    this.seasons,
  });

  factory LiturgicalcalendarData20260117ItemWeekdayCalendar.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260117ItemWeekdayCalendar(
      weekOfSeason: json['weekOfSeason'],
      dayOfSeason: json['dayOfSeason'],
      dayOfWeek: json['dayOfWeek'],
      nthDayOfWeekInMonth: json['nthDayOfWeekInMonth'],
      startOfSeason: json['startOfSeason'],
      endOfSeason: json['endOfSeason'],
      startOfLiturgicalYear: json['startOfLiturgicalYear'],
      endOfLiturgicalYear: json['endOfLiturgicalYear'],
      seasons: (json['seasons'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260117ItemWeekdayCycles {
  String? properCycle;
  String? sundayCycle;
  String? weekdayCycle;
  String? psalterWeek;

  LiturgicalcalendarData20260117ItemWeekdayCycles({
    this.properCycle,
    this.sundayCycle,
    this.weekdayCycle,
    this.psalterWeek,
  });

  factory LiturgicalcalendarData20260117ItemWeekdayCycles.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260117ItemWeekdayCycles(
      properCycle: json['properCycle'],
      sundayCycle: json['sundayCycle'],
      weekdayCycle: json['weekdayCycle'],
      psalterWeek: json['psalterWeek'],
    );
}

class LiturgicalcalendarData20260118Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260118Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260118Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260118Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260119Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260119Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260119Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260119Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260120Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260120Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260120Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260120Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260121Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;
  LiturgicalcalendarData20260121ItemWeekday? weekday;

  LiturgicalcalendarData20260121Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
    this.weekday,
  });

  factory LiturgicalcalendarData20260121Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260121Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
      weekday: json['weekday'] != null ? LiturgicalcalendarData20260121ItemWeekday.fromJson(json['weekday']) : null,
    );
}

class LiturgicalcalendarData20260121ItemWeekday {
  String? id;
  String? date;
  LiturgicalcalendarData20260121ItemWeekdayDatedef? dateDef;
  List<dynamic>? dateExceptions;
  List<dynamic>? alternativeTransferDateDefs;
  String? precedence;
  String? rank;
  bool? allowSimilarRankItems;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? i18nDef;
  List<String>? seasons;
  List<String>? periods;
  List<String>? colors;
  List<dynamic>? commonsDef;
  List<dynamic>? martyrology;
  List<dynamic>? titles;
  LiturgicalcalendarData20260121ItemWeekdayCalendar? calendar;
  LiturgicalcalendarData20260121ItemWeekdayCycles? cycles;
  String? fromCalendarId;
  List<dynamic>? fromExtendedCalendars;

  LiturgicalcalendarData20260121ItemWeekday({
    this.id,
    this.date,
    this.dateDef,
    this.dateExceptions,
    this.alternativeTransferDateDefs,
    this.precedence,
    this.rank,
    this.allowSimilarRankItems,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.i18nDef,
    this.seasons,
    this.periods,
    this.colors,
    this.commonsDef,
    this.martyrology,
    this.titles,
    this.calendar,
    this.cycles,
    this.fromCalendarId,
    this.fromExtendedCalendars,
  });

  factory LiturgicalcalendarData20260121ItemWeekday.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260121ItemWeekday(
      id: json['id'],
      date: json['date'],
      dateDef: json['dateDef'] != null ? LiturgicalcalendarData20260121ItemWeekdayDatedef.fromJson(json['dateDef']) : null,
      dateExceptions: (json['dateExceptions'] as List?)?.cast<dynamic>(),
      alternativeTransferDateDefs: (json['alternativeTransferDateDefs'] as List?)?.cast<dynamic>(),
      precedence: json['precedence'],
      rank: json['rank'],
      allowSimilarRankItems: json['allowSimilarRankItems'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      i18nDef: (json['i18nDef'] as List?)?.cast<String>(),
      seasons: (json['seasons'] as List?)?.cast<String>(),
      periods: (json['periods'] as List?)?.cast<String>(),
      colors: (json['colors'] as List?)?.cast<String>(),
      commonsDef: (json['commonsDef'] as List?)?.cast<dynamic>(),
      martyrology: (json['martyrology'] as List?)?.cast<dynamic>(),
      titles: (json['titles'] as List?)?.cast<dynamic>(),
      calendar: json['calendar'] != null ? LiturgicalcalendarData20260121ItemWeekdayCalendar.fromJson(json['calendar']) : null,
      cycles: json['cycles'] != null ? LiturgicalcalendarData20260121ItemWeekdayCycles.fromJson(json['cycles']) : null,
      fromCalendarId: json['fromCalendarId'],
      fromExtendedCalendars: (json['fromExtendedCalendars'] as List?)?.cast<dynamic>(),
    );
}

class LiturgicalcalendarData20260121ItemWeekdayDatedef {
  String? dateFn;
  List<num>? dateArgs;
  num? yearOffset;

  LiturgicalcalendarData20260121ItemWeekdayDatedef({
    this.dateFn,
    this.dateArgs,
    this.yearOffset,
  });

  factory LiturgicalcalendarData20260121ItemWeekdayDatedef.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260121ItemWeekdayDatedef(
      dateFn: json['dateFn'],
      dateArgs: (json['dateArgs'] as List?)?.cast<num>(),
      yearOffset: json['yearOffset'],
    );
}

class LiturgicalcalendarData20260121ItemWeekdayCalendar {
  num? weekOfSeason;
  num? dayOfSeason;
  num? dayOfWeek;
  num? nthDayOfWeekInMonth;
  String? startOfSeason;
  String? endOfSeason;
  String? startOfLiturgicalYear;
  String? endOfLiturgicalYear;
  List<String>? seasons;

  LiturgicalcalendarData20260121ItemWeekdayCalendar({
    this.weekOfSeason,
    this.dayOfSeason,
    this.dayOfWeek,
    this.nthDayOfWeekInMonth,
    this.startOfSeason,
    this.endOfSeason,
    this.startOfLiturgicalYear,
    this.endOfLiturgicalYear,
    this.seasons,
  });

  factory LiturgicalcalendarData20260121ItemWeekdayCalendar.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260121ItemWeekdayCalendar(
      weekOfSeason: json['weekOfSeason'],
      dayOfSeason: json['dayOfSeason'],
      dayOfWeek: json['dayOfWeek'],
      nthDayOfWeekInMonth: json['nthDayOfWeekInMonth'],
      startOfSeason: json['startOfSeason'],
      endOfSeason: json['endOfSeason'],
      startOfLiturgicalYear: json['startOfLiturgicalYear'],
      endOfLiturgicalYear: json['endOfLiturgicalYear'],
      seasons: (json['seasons'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260121ItemWeekdayCycles {
  String? properCycle;
  String? sundayCycle;
  String? weekdayCycle;
  String? psalterWeek;

  LiturgicalcalendarData20260121ItemWeekdayCycles({
    this.properCycle,
    this.sundayCycle,
    this.weekdayCycle,
    this.psalterWeek,
  });

  factory LiturgicalcalendarData20260121ItemWeekdayCycles.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260121ItemWeekdayCycles(
      properCycle: json['properCycle'],
      sundayCycle: json['sundayCycle'],
      weekdayCycle: json['weekdayCycle'],
      psalterWeek: json['psalterWeek'],
    );
}

class LiturgicalcalendarData20260122Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260122Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260122Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260122Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260123Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260123Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260123Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260123Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260124Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;
  LiturgicalcalendarData20260124ItemWeekday? weekday;

  LiturgicalcalendarData20260124Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
    this.weekday,
  });

  factory LiturgicalcalendarData20260124Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260124Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
      weekday: json['weekday'] != null ? LiturgicalcalendarData20260124ItemWeekday.fromJson(json['weekday']) : null,
    );
}

class LiturgicalcalendarData20260124ItemWeekday {
  String? id;
  String? date;
  LiturgicalcalendarData20260124ItemWeekdayDatedef? dateDef;
  List<dynamic>? dateExceptions;
  List<dynamic>? alternativeTransferDateDefs;
  String? precedence;
  String? rank;
  bool? allowSimilarRankItems;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? i18nDef;
  List<String>? seasons;
  List<String>? periods;
  List<String>? colors;
  List<dynamic>? commonsDef;
  List<dynamic>? martyrology;
  List<dynamic>? titles;
  LiturgicalcalendarData20260124ItemWeekdayCalendar? calendar;
  LiturgicalcalendarData20260124ItemWeekdayCycles? cycles;
  String? fromCalendarId;
  List<dynamic>? fromExtendedCalendars;

  LiturgicalcalendarData20260124ItemWeekday({
    this.id,
    this.date,
    this.dateDef,
    this.dateExceptions,
    this.alternativeTransferDateDefs,
    this.precedence,
    this.rank,
    this.allowSimilarRankItems,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.i18nDef,
    this.seasons,
    this.periods,
    this.colors,
    this.commonsDef,
    this.martyrology,
    this.titles,
    this.calendar,
    this.cycles,
    this.fromCalendarId,
    this.fromExtendedCalendars,
  });

  factory LiturgicalcalendarData20260124ItemWeekday.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260124ItemWeekday(
      id: json['id'],
      date: json['date'],
      dateDef: json['dateDef'] != null ? LiturgicalcalendarData20260124ItemWeekdayDatedef.fromJson(json['dateDef']) : null,
      dateExceptions: (json['dateExceptions'] as List?)?.cast<dynamic>(),
      alternativeTransferDateDefs: (json['alternativeTransferDateDefs'] as List?)?.cast<dynamic>(),
      precedence: json['precedence'],
      rank: json['rank'],
      allowSimilarRankItems: json['allowSimilarRankItems'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      i18nDef: (json['i18nDef'] as List?)?.cast<String>(),
      seasons: (json['seasons'] as List?)?.cast<String>(),
      periods: (json['periods'] as List?)?.cast<String>(),
      colors: (json['colors'] as List?)?.cast<String>(),
      commonsDef: (json['commonsDef'] as List?)?.cast<dynamic>(),
      martyrology: (json['martyrology'] as List?)?.cast<dynamic>(),
      titles: (json['titles'] as List?)?.cast<dynamic>(),
      calendar: json['calendar'] != null ? LiturgicalcalendarData20260124ItemWeekdayCalendar.fromJson(json['calendar']) : null,
      cycles: json['cycles'] != null ? LiturgicalcalendarData20260124ItemWeekdayCycles.fromJson(json['cycles']) : null,
      fromCalendarId: json['fromCalendarId'],
      fromExtendedCalendars: (json['fromExtendedCalendars'] as List?)?.cast<dynamic>(),
    );
}

class LiturgicalcalendarData20260124ItemWeekdayDatedef {
  String? dateFn;
  List<num>? dateArgs;
  num? yearOffset;

  LiturgicalcalendarData20260124ItemWeekdayDatedef({
    this.dateFn,
    this.dateArgs,
    this.yearOffset,
  });

  factory LiturgicalcalendarData20260124ItemWeekdayDatedef.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260124ItemWeekdayDatedef(
      dateFn: json['dateFn'],
      dateArgs: (json['dateArgs'] as List?)?.cast<num>(),
      yearOffset: json['yearOffset'],
    );
}

class LiturgicalcalendarData20260124ItemWeekdayCalendar {
  num? weekOfSeason;
  num? dayOfSeason;
  num? dayOfWeek;
  num? nthDayOfWeekInMonth;
  String? startOfSeason;
  String? endOfSeason;
  String? startOfLiturgicalYear;
  String? endOfLiturgicalYear;
  List<String>? seasons;

  LiturgicalcalendarData20260124ItemWeekdayCalendar({
    this.weekOfSeason,
    this.dayOfSeason,
    this.dayOfWeek,
    this.nthDayOfWeekInMonth,
    this.startOfSeason,
    this.endOfSeason,
    this.startOfLiturgicalYear,
    this.endOfLiturgicalYear,
    this.seasons,
  });

  factory LiturgicalcalendarData20260124ItemWeekdayCalendar.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260124ItemWeekdayCalendar(
      weekOfSeason: json['weekOfSeason'],
      dayOfSeason: json['dayOfSeason'],
      dayOfWeek: json['dayOfWeek'],
      nthDayOfWeekInMonth: json['nthDayOfWeekInMonth'],
      startOfSeason: json['startOfSeason'],
      endOfSeason: json['endOfSeason'],
      startOfLiturgicalYear: json['startOfLiturgicalYear'],
      endOfLiturgicalYear: json['endOfLiturgicalYear'],
      seasons: (json['seasons'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260124ItemWeekdayCycles {
  String? properCycle;
  String? sundayCycle;
  String? weekdayCycle;
  String? psalterWeek;

  LiturgicalcalendarData20260124ItemWeekdayCycles({
    this.properCycle,
    this.sundayCycle,
    this.weekdayCycle,
    this.psalterWeek,
  });

  factory LiturgicalcalendarData20260124ItemWeekdayCycles.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260124ItemWeekdayCycles(
      properCycle: json['properCycle'],
      sundayCycle: json['sundayCycle'],
      weekdayCycle: json['weekdayCycle'],
      psalterWeek: json['psalterWeek'],
    );
}

class LiturgicalcalendarData20260125Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260125Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260125Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260125Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260126Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;
  LiturgicalcalendarData20260126ItemWeekday? weekday;

  LiturgicalcalendarData20260126Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
    this.weekday,
  });

  factory LiturgicalcalendarData20260126Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260126Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
      weekday: json['weekday'] != null ? LiturgicalcalendarData20260126ItemWeekday.fromJson(json['weekday']) : null,
    );
}

class LiturgicalcalendarData20260126ItemWeekday {
  String? id;
  String? date;
  LiturgicalcalendarData20260126ItemWeekdayDatedef? dateDef;
  List<dynamic>? dateExceptions;
  List<dynamic>? alternativeTransferDateDefs;
  String? precedence;
  String? rank;
  bool? allowSimilarRankItems;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? i18nDef;
  List<String>? seasons;
  List<String>? periods;
  List<String>? colors;
  List<dynamic>? commonsDef;
  List<dynamic>? martyrology;
  List<dynamic>? titles;
  LiturgicalcalendarData20260126ItemWeekdayCalendar? calendar;
  LiturgicalcalendarData20260126ItemWeekdayCycles? cycles;
  String? fromCalendarId;
  List<dynamic>? fromExtendedCalendars;

  LiturgicalcalendarData20260126ItemWeekday({
    this.id,
    this.date,
    this.dateDef,
    this.dateExceptions,
    this.alternativeTransferDateDefs,
    this.precedence,
    this.rank,
    this.allowSimilarRankItems,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.i18nDef,
    this.seasons,
    this.periods,
    this.colors,
    this.commonsDef,
    this.martyrology,
    this.titles,
    this.calendar,
    this.cycles,
    this.fromCalendarId,
    this.fromExtendedCalendars,
  });

  factory LiturgicalcalendarData20260126ItemWeekday.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260126ItemWeekday(
      id: json['id'],
      date: json['date'],
      dateDef: json['dateDef'] != null ? LiturgicalcalendarData20260126ItemWeekdayDatedef.fromJson(json['dateDef']) : null,
      dateExceptions: (json['dateExceptions'] as List?)?.cast<dynamic>(),
      alternativeTransferDateDefs: (json['alternativeTransferDateDefs'] as List?)?.cast<dynamic>(),
      precedence: json['precedence'],
      rank: json['rank'],
      allowSimilarRankItems: json['allowSimilarRankItems'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      i18nDef: (json['i18nDef'] as List?)?.cast<String>(),
      seasons: (json['seasons'] as List?)?.cast<String>(),
      periods: (json['periods'] as List?)?.cast<String>(),
      colors: (json['colors'] as List?)?.cast<String>(),
      commonsDef: (json['commonsDef'] as List?)?.cast<dynamic>(),
      martyrology: (json['martyrology'] as List?)?.cast<dynamic>(),
      titles: (json['titles'] as List?)?.cast<dynamic>(),
      calendar: json['calendar'] != null ? LiturgicalcalendarData20260126ItemWeekdayCalendar.fromJson(json['calendar']) : null,
      cycles: json['cycles'] != null ? LiturgicalcalendarData20260126ItemWeekdayCycles.fromJson(json['cycles']) : null,
      fromCalendarId: json['fromCalendarId'],
      fromExtendedCalendars: (json['fromExtendedCalendars'] as List?)?.cast<dynamic>(),
    );
}

class LiturgicalcalendarData20260126ItemWeekdayDatedef {
  String? dateFn;
  List<num>? dateArgs;
  num? yearOffset;

  LiturgicalcalendarData20260126ItemWeekdayDatedef({
    this.dateFn,
    this.dateArgs,
    this.yearOffset,
  });

  factory LiturgicalcalendarData20260126ItemWeekdayDatedef.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260126ItemWeekdayDatedef(
      dateFn: json['dateFn'],
      dateArgs: (json['dateArgs'] as List?)?.cast<num>(),
      yearOffset: json['yearOffset'],
    );
}

class LiturgicalcalendarData20260126ItemWeekdayCalendar {
  num? weekOfSeason;
  num? dayOfSeason;
  num? dayOfWeek;
  num? nthDayOfWeekInMonth;
  String? startOfSeason;
  String? endOfSeason;
  String? startOfLiturgicalYear;
  String? endOfLiturgicalYear;
  List<String>? seasons;

  LiturgicalcalendarData20260126ItemWeekdayCalendar({
    this.weekOfSeason,
    this.dayOfSeason,
    this.dayOfWeek,
    this.nthDayOfWeekInMonth,
    this.startOfSeason,
    this.endOfSeason,
    this.startOfLiturgicalYear,
    this.endOfLiturgicalYear,
    this.seasons,
  });

  factory LiturgicalcalendarData20260126ItemWeekdayCalendar.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260126ItemWeekdayCalendar(
      weekOfSeason: json['weekOfSeason'],
      dayOfSeason: json['dayOfSeason'],
      dayOfWeek: json['dayOfWeek'],
      nthDayOfWeekInMonth: json['nthDayOfWeekInMonth'],
      startOfSeason: json['startOfSeason'],
      endOfSeason: json['endOfSeason'],
      startOfLiturgicalYear: json['startOfLiturgicalYear'],
      endOfLiturgicalYear: json['endOfLiturgicalYear'],
      seasons: (json['seasons'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260126ItemWeekdayCycles {
  String? properCycle;
  String? sundayCycle;
  String? weekdayCycle;
  String? psalterWeek;

  LiturgicalcalendarData20260126ItemWeekdayCycles({
    this.properCycle,
    this.sundayCycle,
    this.weekdayCycle,
    this.psalterWeek,
  });

  factory LiturgicalcalendarData20260126ItemWeekdayCycles.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260126ItemWeekdayCycles(
      properCycle: json['properCycle'],
      sundayCycle: json['sundayCycle'],
      weekdayCycle: json['weekdayCycle'],
      psalterWeek: json['psalterWeek'],
    );
}

class LiturgicalcalendarData20260127Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260127Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260127Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260127Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260128Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;
  LiturgicalcalendarData20260128ItemWeekday? weekday;

  LiturgicalcalendarData20260128Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
    this.weekday,
  });

  factory LiturgicalcalendarData20260128Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260128Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
      weekday: json['weekday'] != null ? LiturgicalcalendarData20260128ItemWeekday.fromJson(json['weekday']) : null,
    );
}

class LiturgicalcalendarData20260128ItemWeekday {
  String? id;
  String? date;
  LiturgicalcalendarData20260128ItemWeekdayDatedef? dateDef;
  List<dynamic>? dateExceptions;
  List<dynamic>? alternativeTransferDateDefs;
  String? precedence;
  String? rank;
  bool? allowSimilarRankItems;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? i18nDef;
  List<String>? seasons;
  List<String>? periods;
  List<String>? colors;
  List<dynamic>? commonsDef;
  List<dynamic>? martyrology;
  List<dynamic>? titles;
  LiturgicalcalendarData20260128ItemWeekdayCalendar? calendar;
  LiturgicalcalendarData20260128ItemWeekdayCycles? cycles;
  String? fromCalendarId;
  List<dynamic>? fromExtendedCalendars;

  LiturgicalcalendarData20260128ItemWeekday({
    this.id,
    this.date,
    this.dateDef,
    this.dateExceptions,
    this.alternativeTransferDateDefs,
    this.precedence,
    this.rank,
    this.allowSimilarRankItems,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.i18nDef,
    this.seasons,
    this.periods,
    this.colors,
    this.commonsDef,
    this.martyrology,
    this.titles,
    this.calendar,
    this.cycles,
    this.fromCalendarId,
    this.fromExtendedCalendars,
  });

  factory LiturgicalcalendarData20260128ItemWeekday.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260128ItemWeekday(
      id: json['id'],
      date: json['date'],
      dateDef: json['dateDef'] != null ? LiturgicalcalendarData20260128ItemWeekdayDatedef.fromJson(json['dateDef']) : null,
      dateExceptions: (json['dateExceptions'] as List?)?.cast<dynamic>(),
      alternativeTransferDateDefs: (json['alternativeTransferDateDefs'] as List?)?.cast<dynamic>(),
      precedence: json['precedence'],
      rank: json['rank'],
      allowSimilarRankItems: json['allowSimilarRankItems'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      i18nDef: (json['i18nDef'] as List?)?.cast<String>(),
      seasons: (json['seasons'] as List?)?.cast<String>(),
      periods: (json['periods'] as List?)?.cast<String>(),
      colors: (json['colors'] as List?)?.cast<String>(),
      commonsDef: (json['commonsDef'] as List?)?.cast<dynamic>(),
      martyrology: (json['martyrology'] as List?)?.cast<dynamic>(),
      titles: (json['titles'] as List?)?.cast<dynamic>(),
      calendar: json['calendar'] != null ? LiturgicalcalendarData20260128ItemWeekdayCalendar.fromJson(json['calendar']) : null,
      cycles: json['cycles'] != null ? LiturgicalcalendarData20260128ItemWeekdayCycles.fromJson(json['cycles']) : null,
      fromCalendarId: json['fromCalendarId'],
      fromExtendedCalendars: (json['fromExtendedCalendars'] as List?)?.cast<dynamic>(),
    );
}

class LiturgicalcalendarData20260128ItemWeekdayDatedef {
  String? dateFn;
  List<num>? dateArgs;
  num? yearOffset;

  LiturgicalcalendarData20260128ItemWeekdayDatedef({
    this.dateFn,
    this.dateArgs,
    this.yearOffset,
  });

  factory LiturgicalcalendarData20260128ItemWeekdayDatedef.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260128ItemWeekdayDatedef(
      dateFn: json['dateFn'],
      dateArgs: (json['dateArgs'] as List?)?.cast<num>(),
      yearOffset: json['yearOffset'],
    );
}

class LiturgicalcalendarData20260128ItemWeekdayCalendar {
  num? weekOfSeason;
  num? dayOfSeason;
  num? dayOfWeek;
  num? nthDayOfWeekInMonth;
  String? startOfSeason;
  String? endOfSeason;
  String? startOfLiturgicalYear;
  String? endOfLiturgicalYear;
  List<String>? seasons;

  LiturgicalcalendarData20260128ItemWeekdayCalendar({
    this.weekOfSeason,
    this.dayOfSeason,
    this.dayOfWeek,
    this.nthDayOfWeekInMonth,
    this.startOfSeason,
    this.endOfSeason,
    this.startOfLiturgicalYear,
    this.endOfLiturgicalYear,
    this.seasons,
  });

  factory LiturgicalcalendarData20260128ItemWeekdayCalendar.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260128ItemWeekdayCalendar(
      weekOfSeason: json['weekOfSeason'],
      dayOfSeason: json['dayOfSeason'],
      dayOfWeek: json['dayOfWeek'],
      nthDayOfWeekInMonth: json['nthDayOfWeekInMonth'],
      startOfSeason: json['startOfSeason'],
      endOfSeason: json['endOfSeason'],
      startOfLiturgicalYear: json['startOfLiturgicalYear'],
      endOfLiturgicalYear: json['endOfLiturgicalYear'],
      seasons: (json['seasons'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260128ItemWeekdayCycles {
  String? properCycle;
  String? sundayCycle;
  String? weekdayCycle;
  String? psalterWeek;

  LiturgicalcalendarData20260128ItemWeekdayCycles({
    this.properCycle,
    this.sundayCycle,
    this.weekdayCycle,
    this.psalterWeek,
  });

  factory LiturgicalcalendarData20260128ItemWeekdayCycles.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260128ItemWeekdayCycles(
      properCycle: json['properCycle'],
      sundayCycle: json['sundayCycle'],
      weekdayCycle: json['weekdayCycle'],
      psalterWeek: json['psalterWeek'],
    );
}

class LiturgicalcalendarData20260129Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260129Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260129Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260129Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260130Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;

  LiturgicalcalendarData20260130Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
  });

  factory LiturgicalcalendarData20260130Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260130Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260131Item {
  String? id;
  String? precedence;
  String? rank;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? colors;
  LiturgicalcalendarData20260131ItemWeekday? weekday;

  LiturgicalcalendarData20260131Item({
    this.id,
    this.precedence,
    this.rank,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.colors,
    this.weekday,
  });

  factory LiturgicalcalendarData20260131Item.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260131Item(
      id: json['id'],
      precedence: json['precedence'],
      rank: json['rank'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      colors: (json['colors'] as List?)?.cast<String>(),
      weekday: json['weekday'] != null ? LiturgicalcalendarData20260131ItemWeekday.fromJson(json['weekday']) : null,
    );
}

class LiturgicalcalendarData20260131ItemWeekday {
  String? id;
  String? date;
  LiturgicalcalendarData20260131ItemWeekdayDatedef? dateDef;
  List<dynamic>? dateExceptions;
  List<dynamic>? alternativeTransferDateDefs;
  String? precedence;
  String? rank;
  bool? allowSimilarRankItems;
  bool? isHolyDayOfObligation;
  bool? isOptional;
  List<String>? i18nDef;
  List<String>? seasons;
  List<String>? periods;
  List<String>? colors;
  List<dynamic>? commonsDef;
  List<dynamic>? martyrology;
  List<dynamic>? titles;
  LiturgicalcalendarData20260131ItemWeekdayCalendar? calendar;
  LiturgicalcalendarData20260131ItemWeekdayCycles? cycles;
  String? fromCalendarId;
  List<dynamic>? fromExtendedCalendars;

  LiturgicalcalendarData20260131ItemWeekday({
    this.id,
    this.date,
    this.dateDef,
    this.dateExceptions,
    this.alternativeTransferDateDefs,
    this.precedence,
    this.rank,
    this.allowSimilarRankItems,
    this.isHolyDayOfObligation,
    this.isOptional,
    this.i18nDef,
    this.seasons,
    this.periods,
    this.colors,
    this.commonsDef,
    this.martyrology,
    this.titles,
    this.calendar,
    this.cycles,
    this.fromCalendarId,
    this.fromExtendedCalendars,
  });

  factory LiturgicalcalendarData20260131ItemWeekday.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260131ItemWeekday(
      id: json['id'],
      date: json['date'],
      dateDef: json['dateDef'] != null ? LiturgicalcalendarData20260131ItemWeekdayDatedef.fromJson(json['dateDef']) : null,
      dateExceptions: (json['dateExceptions'] as List?)?.cast<dynamic>(),
      alternativeTransferDateDefs: (json['alternativeTransferDateDefs'] as List?)?.cast<dynamic>(),
      precedence: json['precedence'],
      rank: json['rank'],
      allowSimilarRankItems: json['allowSimilarRankItems'],
      isHolyDayOfObligation: json['isHolyDayOfObligation'],
      isOptional: json['isOptional'],
      i18nDef: (json['i18nDef'] as List?)?.cast<String>(),
      seasons: (json['seasons'] as List?)?.cast<String>(),
      periods: (json['periods'] as List?)?.cast<String>(),
      colors: (json['colors'] as List?)?.cast<String>(),
      commonsDef: (json['commonsDef'] as List?)?.cast<dynamic>(),
      martyrology: (json['martyrology'] as List?)?.cast<dynamic>(),
      titles: (json['titles'] as List?)?.cast<dynamic>(),
      calendar: json['calendar'] != null ? LiturgicalcalendarData20260131ItemWeekdayCalendar.fromJson(json['calendar']) : null,
      cycles: json['cycles'] != null ? LiturgicalcalendarData20260131ItemWeekdayCycles.fromJson(json['cycles']) : null,
      fromCalendarId: json['fromCalendarId'],
      fromExtendedCalendars: (json['fromExtendedCalendars'] as List?)?.cast<dynamic>(),
    );
}

class LiturgicalcalendarData20260131ItemWeekdayDatedef {
  String? dateFn;
  List<num>? dateArgs;
  num? yearOffset;

  LiturgicalcalendarData20260131ItemWeekdayDatedef({
    this.dateFn,
    this.dateArgs,
    this.yearOffset,
  });

  factory LiturgicalcalendarData20260131ItemWeekdayDatedef.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260131ItemWeekdayDatedef(
      dateFn: json['dateFn'],
      dateArgs: (json['dateArgs'] as List?)?.cast<num>(),
      yearOffset: json['yearOffset'],
    );
}

class LiturgicalcalendarData20260131ItemWeekdayCalendar {
  num? weekOfSeason;
  num? dayOfSeason;
  num? dayOfWeek;
  num? nthDayOfWeekInMonth;
  String? startOfSeason;
  String? endOfSeason;
  String? startOfLiturgicalYear;
  String? endOfLiturgicalYear;
  List<String>? seasons;

  LiturgicalcalendarData20260131ItemWeekdayCalendar({
    this.weekOfSeason,
    this.dayOfSeason,
    this.dayOfWeek,
    this.nthDayOfWeekInMonth,
    this.startOfSeason,
    this.endOfSeason,
    this.startOfLiturgicalYear,
    this.endOfLiturgicalYear,
    this.seasons,
  });

  factory LiturgicalcalendarData20260131ItemWeekdayCalendar.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260131ItemWeekdayCalendar(
      weekOfSeason: json['weekOfSeason'],
      dayOfSeason: json['dayOfSeason'],
      dayOfWeek: json['dayOfWeek'],
      nthDayOfWeekInMonth: json['nthDayOfWeekInMonth'],
      startOfSeason: json['startOfSeason'],
      endOfSeason: json['endOfSeason'],
      startOfLiturgicalYear: json['startOfLiturgicalYear'],
      endOfLiturgicalYear: json['endOfLiturgicalYear'],
      seasons: (json['seasons'] as List?)?.cast<String>(),
    );
}

class LiturgicalcalendarData20260131ItemWeekdayCycles {
  String? properCycle;
  String? sundayCycle;
  String? weekdayCycle;
  String? psalterWeek;

  LiturgicalcalendarData20260131ItemWeekdayCycles({
    this.properCycle,
    this.sundayCycle,
    this.weekdayCycle,
    this.psalterWeek,
  });

  factory LiturgicalcalendarData20260131ItemWeekdayCycles.fromJson(Map<String, dynamic> json) => LiturgicalcalendarData20260131ItemWeekdayCycles(
      properCycle: json['properCycle'],
      sundayCycle: json['sundayCycle'],
      weekdayCycle: json['weekdayCycle'],
      psalterWeek: json['psalterWeek'],
    );
}

class LiturgicalcalendarRequest {
  int? month;
  int? year;

  LiturgicalcalendarRequest({
    this.month,
    this.year,
  });

  Map<String, dynamic> toJson() => {
      if (month != null) 'month': month,
      if (year != null) 'year': year,
    };
}
