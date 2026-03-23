package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020#0(¢\u0006\u0002\b)H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001d\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u00101\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u00104\u001a-\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0003¢\u0006\u0002\u00107\u001a\u0015\u00108\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u00109\u001a\u001d\u0010:\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u0010;\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u0010<\u001a1\u0010=\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u0010>\u001a=\u0010?\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0003¢\u0006\u0002\u0010E\u001a)\u0010F\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u0010G\u001a%\u0010H\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010I\u001a8\u0010J\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010K\u001a\u00020LH\u0007ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a \u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u000203H\u0007\u001ab\u0010S\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00106\u001a\u00020T2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020#0V2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\b\b\u0002\u0010Y\u001a\u00020Z2\b\b\u0002\u0010[\u001a\u00020\\2\u0006\u0010.\u001a\u00020/H\u0003ø\u0001\u0000¢\u0006\u0004\b]\u0010^\u001a:\u0010_\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00106\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\u0006\u0010.\u001a\u00020/H\u0003ø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001aQ\u0010b\u001a\u00020#2\u0006\u0010c\u001a\u0002032\u0006\u0010d\u001a\u00020C2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020#0(2\u0006\u0010.\u001a\u00020/2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020#0V¢\u0006\u0002\b)¢\u0006\u0002\bgH\u0003¢\u0006\u0002\u0010h\u001a\u001d\u0010i\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u0010j\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u0010<\u001a1\u0010k\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u0010>\u001a\u0018\u0010l\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0006\u0010n\u001a\u00020\bH\u0002\u001a(\u0010o\u001a\u00020\b2\u0006\u0010p\u001a\u00020\b2\u0006\u0010q\u001a\u00020\b2\u0006\u0010r\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u0019H\u0002\u001a*\u0010t\u001a\u00020u2\u0006\u0010W\u001a\u00020X2\u0006\u0010R\u001a\u0002032\u0006\u0010v\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\bw\u0010x\u001a+\u0010y\u001a\u00020\u001a2\b\b\u0002\u0010P\u001a\u00020\u00192\b\b\u0002\u0010Q\u001a\u00020\u00192\b\b\u0002\u0010R\u001a\u000203H\u0007¢\u0006\u0002\u0010z\u001a`\u0010{\u001a\u00020#2\u0006\u0010W\u001a\u00020X2\u0006\u0010-\u001a\u00020\u001a2\u0006\u00106\u001a\u00020T2\u0006\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u00020\u00192\"\u0010~\u001a\u001e\u0012\u0014\u0012\u00120T¢\u0006\r\b\u007f\u0012\t\b\u0080\u0001\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020#0VH\u0002ø\u0001\u0000¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u001d\u0010\u0083\u0001\u001a\u00020%*\u00020%2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002\u001a<\u0010\u0084\u0001\u001a\u00020#*\u00020\u001a2\u0006\u0010n\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0007\u0010\u0085\u0001\u001a\u00020\b2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001\u001aE\u0010\u008a\u0001\u001a\u00020#*\u00020\u001f2\u0006\u0010n\u001a\u00020\b2\u0006\u0010m\u001a\u00020\b2\u0007\u0010\u0085\u0001\u001a\u00020\b2\u0006\u00102\u001a\u0002032\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0016\u0010\u008d\u0001\u001a\u00020%*\u00020%2\u0007\u0010\u008d\u0001\u001a\u000203H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"\u0018\u0010\u001d\u001a\u00020\u001e*\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u008e\u0001²\u0006\u000b\u0010\u008f\u0001\u001a\u000203X\u008a\u0084\u0002²\u0006\u000b\u0010\u0090\u0001\u001a\u00020TX\u008a\u008e\u0002²\u0006\u000b\u0010\u0091\u0001\u001a\u00020TX\u008a\u008e\u0002²\u0006\f\u0010\u0086\u0001\u001a\u00030\u0092\u0001X\u008a\u008e\u0002²\u0006\f\u0010\u0093\u0001\u001a\u00030\u0087\u0001X\u008a\u008e\u0002"}, d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "Landroidx/collection/IntList;", "FullCircle", "", "HalfCircle", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "hourForDisplay", "", "Landroidx/compose/material3/TimePickerState;", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/material3/AnalogTimePickerState;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", "value", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerState", "initialHour", "initialMinute", "is24Hour", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-SAnMeKU", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "number", "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "timeInputOnChange-z7XvuPQ", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "drawSelector", "moveSelector", "maxDist", "center", "Landroidx/compose/ui/unit/IntOffset;", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "onTap", "onTap-rOwcSBo", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visible", "material3_release", "a11yServicesEnabled", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimePickerKt {
    private static final IntList ExtraHours;
    private static final float FullCircle = 6.2831855f;
    private static final float HalfCircle = 3.1415927f;
    private static final float PeriodToggleMargin;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float OuterCircleSizeRadius = Dp.m6693constructorimpl(101);
    private static final float InnerCircleRadius = Dp.m6693constructorimpl(69);
    private static final float ClockDisplayBottomMargin = Dp.m6693constructorimpl(36);
    private static final float ClockFaceBottomMargin = Dp.m6693constructorimpl(24);
    private static final float DisplaySeparatorWidth = Dp.m6693constructorimpl(24);
    private static final float SupportLabelTop = Dp.m6693constructorimpl(7);
    private static final float TimeInputBottomPadding = Dp.m6693constructorimpl(24);
    private static final float MaxDistance = Dp.m6693constructorimpl(74);
    private static final float MinimumInteractiveSize = Dp.m6693constructorimpl(48);
    private static final IntList Minutes = IntListKt.intListOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55);
    private static final IntList Hours = IntListKt.intListOf(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

    /* renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    public static final void m2738TimePickermT9BvqQ(final TimePickerState state, Modifier modifier, TimePickerColors colors, int layoutType, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TimePickerColors timePickerColors;
        int i2;
        TimePickerColors colors2;
        Modifier modifier3;
        int $dirty;
        int $dirty2;
        TimePickerColors colors3;
        Object value$iv;
        final int layoutType2;
        final Modifier modifier4;
        final TimePickerColors colors4;
        Composer $composer2 = $composer.startRestartGroup(-619286452);
        ComposerKt.sourceInformation($composer2, "C(TimePicker)P(3,2!,1:c#material3.TimePickerLayoutType)218@11441L8,219@11509L12,221@11558L35,222@11616L48:TimePicker.kt#uh7d8r");
        int $dirty3 = $changed;
        if ((i & 1) != 0) {
            $dirty3 |= 6;
        } else if (($changed & 6) == 0) {
            $dirty3 |= ($changed & 8) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty3 |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty3 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                timePickerColors = colors;
                int i4 = $composer2.changed(timePickerColors) ? 256 : 128;
                $dirty3 |= i4;
            } else {
                timePickerColors = colors;
            }
            $dirty3 |= i4;
        } else {
            timePickerColors = colors;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                i2 = layoutType;
                int i5 = $composer2.changed(i2) ? 2048 : 1024;
                $dirty3 |= i5;
            } else {
                i2 = layoutType;
            }
            $dirty3 |= i5;
        } else {
            i2 = layoutType;
        }
        if (($dirty3 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            colors4 = timePickerColors;
            layoutType2 = i2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier5 = i3 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    colors2 = TimePickerDefaults.INSTANCE.colors($composer2, 6);
                    $dirty3 &= -897;
                } else {
                    colors2 = timePickerColors;
                }
                if ((i & 8) != 0) {
                    Modifier modifier6 = modifier5;
                    $dirty = $dirty3 & (-7169);
                    $dirty2 = TimePickerDefaults.INSTANCE.m2736layoutTypesDNSZnc($composer2, 6);
                    modifier3 = modifier6;
                    colors3 = colors2;
                } else {
                    modifier3 = modifier5;
                    $dirty = $dirty3;
                    $dirty2 = i2;
                    colors3 = colors2;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty3 &= -897;
                }
                if ((i & 8) != 0) {
                    $dirty3 &= -7169;
                }
                $dirty = $dirty3;
                $dirty2 = i2;
                colors3 = timePickerColors;
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-619286452, $dirty, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:220)");
            }
            boolean invalid$iv = false;
            State a11yServicesEnabled$delegate = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, $composer2, 0, 3);
            ComposerKt.sourceInformationMarkerStart($composer2, -2089091954, "CC(remember):TimePicker.kt#9igjgp");
            if (($dirty & 14) == 4 || (($dirty & 8) != 0 && $composer2.changed(state))) {
                invalid$iv = true;
            }
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new AnalogTimePickerState(state);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            AnalogTimePickerState analogState = (AnalogTimePickerState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (TimePickerLayoutType.m2756equalsimpl0($dirty2, TimePickerLayoutType.INSTANCE.m2761getVerticalQJTpgSE())) {
                $composer2.startReplaceGroup(-337235422);
                ComposerKt.sourceInformation($composer2, "224@11728L178");
                VerticalTimePicker(analogState, modifier3, colors3, true ^ TimePicker_mT9BvqQ$lambda$0(a11yServicesEnabled$delegate), $composer2, ($dirty & 112) | ($dirty & 896), 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-337036960);
                ComposerKt.sourceInformation($composer2, "231@11928L180");
                HorizontalTimePicker(analogState, modifier3, colors3, true ^ TimePicker_mT9BvqQ$lambda$0(a11yServicesEnabled$delegate), $composer2, ($dirty & 112) | ($dirty & 896), 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            layoutType2 = $dirty2;
            modifier4 = modifier3;
            colors4 = colors3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimePicker$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    TimePickerKt.m2738TimePickermT9BvqQ(state, modifier4, colors4, layoutType2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> state) {
        Object thisObj$iv = state.getValue();
        return ((Boolean) thisObj$iv).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void TimeInput(final androidx.compose.material3.TimePickerState r8, androidx.compose.ui.Modifier r9, androidx.compose.material3.TimePickerColors r10, androidx.compose.runtime.Composer r11, final int r12, final int r13) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.TimeInput(androidx.compose.material3.TimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final TimePickerState rememberTimePickerState(final int initialHour, final int initialMinute, boolean is24Hour, Composer $composer, int $changed, int i) {
        final boolean is24Hour2;
        Object value$iv;
        ComposerKt.sourceInformationMarkerStart($composer, 1237715277, "C(rememberTimePickerState)572@28878L14,575@29014L185,575@28960L239:TimePicker.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialHour = 0;
        }
        if ((i & 2) != 0) {
            initialMinute = 0;
        }
        if ((i & 4) == 0) {
            is24Hour2 = is24Hour;
        } else {
            is24Hour2 = TimeFormat_androidKt.is24HourFormat($composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1237715277, $changed, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:573)");
        }
        Object[] objArr = new Object[0];
        Saver<TimePickerStateImpl, ?> Saver = TimePickerStateImpl.INSTANCE.Saver();
        ComposerKt.sourceInformationMarkerStart($composer, -1964549601, "CC(remember):TimePicker.kt#9igjgp");
        boolean invalid$iv = (((($changed & 14) ^ 6) > 4 && $composer.changed(initialHour)) || ($changed & 6) == 4) | (((($changed & 112) ^ 48) > 32 && $composer.changed(initialMinute)) || ($changed & 48) == 32) | (((($changed & 896) ^ 384) > 256 && $composer.changed(is24Hour2)) || ($changed & 384) == 256);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = (Function0) new Function0<TimePickerStateImpl>() { // from class: androidx.compose.material3.TimePickerKt$rememberTimePickerState$state$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TimePickerStateImpl invoke() {
                    return new TimePickerStateImpl(initialHour, initialMinute, is24Hour2);
                }
            };
            $composer.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        TimePickerStateImpl state = (TimePickerStateImpl) RememberSaveableKt.m3772rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) value$iv, $composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return state;
    }

    public static final TimePickerState TimePickerState(int initialHour, int initialMinute, boolean is24Hour) {
        return new TimePickerStateImpl(initialHour, initialMinute, is24Hour);
    }

    public static final int getHourForDisplay(TimePickerState $this$hourForDisplay) {
        if ($this$hourForDisplay.getIs24hour()) {
            return $this$hourForDisplay.getHour() % 24;
        }
        if ($this$hourForDisplay.getHour() % 12 == 0) {
            return 12;
        }
        return $this$hourForDisplay.isAfternoon() ? $this$hourForDisplay.getHour() - 12 : $this$hourForDisplay.getHour();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: moveSelector-d3b8Pxo, reason: not valid java name */
    public static final void m2747moveSelectord3b8Pxo(TimePickerState $this$moveSelector_u2dd3b8Pxo, float x, float y, float maxDist, long center) {
        if (!TimePickerSelectionMode.m2765equalsimpl0($this$moveSelector_u2dd3b8Pxo.mo1778getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2769getHouryecRtBI()) || !$this$moveSelector_u2dd3b8Pxo.getIs24hour()) {
            return;
        }
        $this$moveSelector_u2dd3b8Pxo.setAfternoon(dist(x, y, IntOffset.m6825getXimpl(center), IntOffset.m6826getYimpl(center)) < maxDist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* renamed from: onTap-rOwcSBo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m2749onTaprOwcSBo(androidx.compose.material3.AnalogTimePickerState r8, float r9, float r10, float r11, boolean r12, long r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            boolean r0 = r15 instanceof androidx.compose.material3.TimePickerKt$onTap$1
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.material3.TimePickerKt$onTap$1 r0 = (androidx.compose.material3.TimePickerKt$onTap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L19
        L14:
            androidx.compose.material3.TimePickerKt$onTap$1 r0 = new androidx.compose.material3.TimePickerKt$onTap$1
            r0.<init>(r15)
        L19:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            switch(r2) {
                case 0: goto L41;
                case 1: goto L37;
                case 2: goto L2c;
                default: goto L24;
            }
        L24:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L2c:
            boolean r8 = r0.Z$0
            java.lang.Object r9 = r0.L$0
            androidx.compose.material3.AnalogTimePickerState r9 = (androidx.compose.material3.AnalogTimePickerState) r9
            kotlin.ResultKt.throwOnFailure(r15)
            goto Lc4
        L37:
            boolean r8 = r0.Z$0
            java.lang.Object r9 = r0.L$0
            androidx.compose.material3.AnalogTimePickerState r9 = (androidx.compose.material3.AnalogTimePickerState) r9
            kotlin.ResultKt.throwOnFailure(r15)
            goto La2
        L41:
            kotlin.ResultKt.throwOnFailure(r15)
            r2 = r12
            r12 = r11
            int r11 = androidx.compose.ui.unit.IntOffset.m6826getYimpl(r13)
            float r11 = (float) r11
            float r11 = r10 - r11
            int r3 = androidx.compose.ui.unit.IntOffset.m6825getXimpl(r13)
            float r3 = (float) r3
            float r3 = r9 - r3
            float r11 = atan(r11, r3)
            int r3 = r8.mo1778getSelectionyecRtBI()
            androidx.compose.material3.TimePickerSelectionMode$Companion r4 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE
            int r4 = r4.m2770getMinuteyecRtBI()
            boolean r3 = androidx.compose.material3.TimePickerSelectionMode.m2765equalsimpl0(r3, r4)
            if (r3 == 0) goto L7c
            r3 = 1037465424(0x3dd67750, float:0.10471976)
            float r4 = r11 / r3
            r5 = 1084227584(0x40a00000, float:5.0)
            float r4 = r4 / r5
            double r6 = (double) r4
            double r6 = java.lang.Math.rint(r6)
            float r11 = (float) r6
            float r11 = r11 * r5
            float r11 = r11 * r3
            r3 = r11
            goto L8a
        L7c:
            r3 = 1057360530(0x3f060a92, float:0.5235988)
            float r4 = r11 / r3
            double r4 = (double) r4
            double r4 = java.lang.Math.rint(r4)
            float r11 = (float) r4
            float r11 = r11 * r3
            r3 = r11
        L8a:
            r11 = r10
            r10 = r9
            r9 = r8
            androidx.compose.material3.TimePickerState r9 = (androidx.compose.material3.TimePickerState) r9
            m2747moveSelectord3b8Pxo(r9, r10, r11, r12, r13)
            r0.L$0 = r8
            r0.Z$0 = r2
            r9 = 1
            r0.label = r9
            java.lang.Object r9 = r8.rotateTo(r3, r9, r0)
            if (r9 != r1) goto La0
            return r1
        La0:
            r9 = r8
            r8 = r2
        La2:
            int r10 = r9.mo1778getSelectionyecRtBI()
            androidx.compose.material3.TimePickerSelectionMode$Companion r11 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE
            int r11 = r11.m2769getHouryecRtBI()
            boolean r10 = androidx.compose.material3.TimePickerSelectionMode.m2765equalsimpl0(r10, r11)
            if (r10 == 0) goto Lc5
            if (r8 == 0) goto Lc5
            r0.L$0 = r9
            r0.Z$0 = r8
            r10 = 2
            r0.label = r10
            r10 = 100
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r10, r0)
            if (r10 != r1) goto Lc4
            return r1
        Lc4:
        Lc5:
            if (r8 == 0) goto Ld0
            androidx.compose.material3.TimePickerSelectionMode$Companion r8 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE
            int r8 = r8.m2770getMinuteyecRtBI()
            r9.mo1779setSelection6_8s6DQ(r8)
        Ld0:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2749onTaprOwcSBo(androidx.compose.material3.AnalogTimePickerState, float, float, float, boolean, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final long getSelectorPos(AnalogTimePickerState $this$selectorPos) {
        float arg0$iv = Dp.m6693constructorimpl(TimePickerTokens.INSTANCE.m3558getClockDialSelectorHandleContainerSizeD9Ej5fM() / 2);
        float length = Dp.m6693constructorimpl(Dp.m6693constructorimpl((($this$selectorPos.getIs24hour() && $this$selectorPos.isAfternoon() && TimePickerSelectionMode.m2765equalsimpl0($this$selectorPos.mo1778getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2769getHouryecRtBI())) ? InnerCircleRadius : OuterCircleSizeRadius) - arg0$iv) + arg0$iv);
        float other$iv = (float) Math.cos($this$selectorPos.getCurrentAngle());
        float arg0$iv2 = Dp.m6693constructorimpl(Dp.m6693constructorimpl(length * other$iv) + Dp.m6693constructorimpl(TimePickerTokens.INSTANCE.m3556getClockDialContainerSizeD9Ej5fM() / 2));
        float other$iv2 = (float) Math.sin($this$selectorPos.getCurrentAngle());
        return DpKt.m6714DpOffsetYgX7TsA(arg0$iv2, Dp.m6693constructorimpl(Dp.m6693constructorimpl(length * other$iv2) + Dp.m6693constructorimpl(TimePickerTokens.INSTANCE.m3556getClockDialContainerSizeD9Ej5fM() / 2)));
    }

    public static final void VerticalTimePicker(final AnalogTimePickerState state, Modifier modifier, TimePickerColors colors, final boolean autoSwitchToMinute, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        TimePickerColors colors2;
        Modifier.Companion modifier3;
        Function0 factory$iv$iv$iv;
        final TimePickerColors colors3;
        final Modifier modifier4;
        Composer $composer2 = $composer.startRestartGroup(1249591487);
        ComposerKt.sourceInformation($composer2, "C(VerticalTimePicker)P(3,2,1)927@40188L8,930@40238L379:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 384) == 0) {
            if ((i & 4) == 0) {
                colors2 = colors;
                int i3 = $composer2.changed(colors2) ? 256 : 128;
                $dirty |= i3;
            } else {
                colors2 = colors;
            }
            $dirty |= i3;
        } else {
            colors2 = colors;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(autoSwitchToMinute) ? 2048 : 1024;
        }
        if (($dirty & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            colors3 = colors2;
            modifier4 = modifier2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                modifier3 = i2 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i & 4) != 0) {
                    $dirty &= -897;
                    colors2 = TimePickerDefaults.INSTANCE.colors($composer2, 6);
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 4) != 0) {
                    $dirty &= -897;
                }
                modifier3 = modifier2;
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1249591487, $dirty, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:929)");
            }
            Modifier modifier$iv = SemanticsModifierKt.semantics$default(modifier3, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalTimePicker.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                    SemanticsPropertiesKt.setTraversalGroup($this$semantics, true);
                }
            }, 1, null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer2, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            int $dirty2 = $dirty;
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Modifier modifier5 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i4 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i5 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1628603633, "C934@40388L35,935@40432L60,936@40501L44,937@40554L57:TimePicker.kt#uh7d8r");
            VerticalClockDisplay(state, colors2, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 112));
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, ClockDisplayBottomMargin), $composer2, 6);
            ClockFace(state, colors2, autoSwitchToMinute, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & 112) | (($dirty2 >> 3) & 896));
            SpacerKt.Spacer(SizeKt.m712height3ABfNKs(Modifier.INSTANCE, ClockFaceBottomMargin), $composer2, 6);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            colors3 = colors2;
            modifier4 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalTimePicker.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    TimePickerKt.VerticalTimePicker(state, modifier4, colors3, autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x0236  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void HorizontalTimePicker(final androidx.compose.material3.AnalogTimePickerState r28, androidx.compose.ui.Modifier r29, androidx.compose.material3.TimePickerColors r30, final boolean r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalTimePicker(androidx.compose.material3.AnalogTimePickerState, androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerColors, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TimeInputImpl(final Modifier modifier, final TimePickerColors colors, final TimePickerState state, Composer $composer, final int $changed) {
        Object value$iv;
        Object value$iv2;
        Function0 factory$iv$iv$iv;
        Composer $composer2;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-475657989);
        ComposerKt.sourceInformation($composer3, "C(TimeInputImpl)P(1)965@41356L112,965@41304L164,969@41552L104,969@41500L156,972@41661L4502:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(colors) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer3.changed(state) : $composer3.changedInstance(state) ? 256 : 128;
        }
        if (($dirty & 147) == 146 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-475657989, $dirty, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:963)");
            }
            Object[] objArr = new Object[0];
            Saver<TextFieldValue, Object> saver = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart($composer3, 339122986, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = ($dirty & 896) == 256 || (($dirty & 512) != 0 && $composer3.changedInstance(state));
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$hourValue$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(TimePickerKt.getHourForDisplay(state), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final MutableState hourValue$delegate = RememberSaveableKt.rememberSaveable(objArr, (Saver) saver, (String) null, (Function0) value$iv, $composer3, 0, 4);
            Object[] objArr2 = new Object[0];
            Saver<TextFieldValue, Object> saver2 = TextFieldValue.INSTANCE.getSaver();
            ComposerKt.sourceInformationMarkerStart($composer3, 339129250, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv2 = ($dirty & 896) == 256 || (($dirty & 512) != 0 && $composer3.changedInstance(state));
            Object it$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$minuteValue$2$1
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final MutableState<TextFieldValue> invoke() {
                        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(state.getMinute(), 2, 0, false, 6, null), 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            } else {
                value$iv2 = it$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            final MutableState minuteValue$delegate = RememberSaveableKt.rememberSaveable(objArr2, (Saver) saver2, (String) null, (Function0) value$iv2, $composer3, 0, 4);
            int $dirty2 = $dirty;
            Modifier modifier$iv = PaddingKt.m685paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, TimeInputBottomPadding, 7, null);
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer3);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1328966913, "C977@41861L5,986@42225L3553,982@42004L3774:TimePicker.kt#uh7d8r");
            TextStyle textStyle = TextStyle.m6159copyp1EtxEg$default(TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont(), $composer3, 6), colors.m2734timeSelectorContentColorvNxB06k$material3_release(true), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6550getCentere0LSkKk(), 0, 0L, null, null, null, 0, 0, null, 16744446, null);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(textStyle), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(1306700887, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:55:0x029f  */
                /* JADX WARN: Removed duplicated region for block: B:62:0x02de  */
                /* JADX WARN: Removed duplicated region for block: B:69:0x033a  */
                /* JADX WARN: Removed duplicated region for block: B:72:0x038b  */
                /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke(androidx.compose.runtime.Composer r48, int r49) {
                    /*
                        Method dump skipped, instructions count: 911
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt$TimeInputImpl$1$1.invoke(androidx.compose.runtime.Composer, int):void");
                }
            }, $composer3, 54), $composer3, ProvidedValue.$stable | 48);
            $composer3.startReplaceGroup(511443242);
            ComposerKt.sourceInformation($composer3, "1073@45823L324");
            if (state.getIs24hour()) {
                $composer2 = $composer3;
            } else {
                Modifier modifier$iv2 = PaddingKt.m685paddingqDBjuR0$default(Modifier.INSTANCE, PeriodToggleMargin, 0.0f, 0.0f, 0.0f, 14, null);
                ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv2 = (6 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv2 = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!($composer3.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.createNode(factory$iv$iv$iv2);
                } else {
                    factory$iv$iv$iv2 = factory$iv$iv$iv4;
                    $composer3.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.m3678constructorimpl($composer3);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2 block$iv$iv$iv2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if ($this$Layout_u24lambda_u240$iv$iv2.getInserting()) {
                    $composer2 = $composer3;
                } else {
                    $composer2 = $composer3;
                    if (!Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv2.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv2))) {
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                    int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
                    Composer $composer$iv = $composer2;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i4 = ((6 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer$iv, -415465671, "C1074@45891L242:TimePicker.kt#uh7d8r");
                    VerticalPeriodToggle(SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3551getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3550getPeriodSelectorContainerHeightD9Ej5fM()), state, colors, $composer$iv, (($dirty2 >> 3) & 112) | 6 | (($dirty2 << 3) & 896));
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                }
                $this$Layout_u24lambda_u240$iv$iv2.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv2));
                $this$Layout_u24lambda_u240$iv$iv2.apply(Integer.valueOf(compositeKeyHash$iv$iv2), block$iv$iv$iv2);
                Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.INSTANCE.getSetModifier());
                int i32 = ($changed$iv$iv$iv2 >> 6) & 14;
                Composer $composer$iv2 = $composer2;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                int i42 = ((6 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer$iv2, -415465671, "C1074@45891L242:TimePicker.kt#uh7d8r");
                VerticalPeriodToggle(SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, TimeInputTokens.INSTANCE.m3551getPeriodSelectorContainerWidthD9Ej5fM(), TimeInputTokens.INSTANCE.m3550getPeriodSelectorContainerHeightD9Ej5fM()), state, colors, $composer$iv2, (($dirty2 >> 3) & 112) | 6 | (($dirty2 << 3) & 896));
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer$iv2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
            }
            $composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.TimeInputImpl.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i5) {
                    TimePickerKt.TimeInputImpl(modifier, colors, state, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$6(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextFieldValue TimeInputImpl$lambda$9(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x030c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void HorizontalClockDisplay(final androidx.compose.material3.TimePickerState r50, final androidx.compose.material3.TimePickerColors r51, androidx.compose.runtime.Composer r52, final int r53) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.HorizontalClockDisplay(androidx.compose.material3.TimePickerState, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x030c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void VerticalClockDisplay(final androidx.compose.material3.TimePickerState r50, final androidx.compose.material3.TimePickerColors r51, androidx.compose.runtime.Composer r52, final int r53) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.VerticalClockDisplay(androidx.compose.material3.TimePickerState, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockDisplayNumbers(final TimePickerState state, final TimePickerColors colors, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-934561141);
        ComposerKt.sourceInformation($composer2, "C(ClockDisplayNumbers)P(1)1128@47738L5,1131@47873L775,1127@47654L994:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= ($changed & 8) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(colors) ? 32 : 16;
        }
        if (($dirty & 19) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-934561141, $dirty, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1126)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), $composer2, 6)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(-477913269, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C1132@47883L759:TimePicker.kt#uh7d8r");
                    if (($changed2 & 3) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-477913269, $changed2, -1, "androidx.compose.material3.ClockDisplayNumbers.<anonymous> (TimePicker.kt:1132)");
                        }
                        TimePickerState timePickerState = state;
                        TimePickerColors timePickerColors = colors;
                        ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                        Modifier modifier$iv = Modifier.INSTANCE;
                        Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getTop();
                        MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                        int $changed$iv$iv = (0 << 3) & 112;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                        CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
                        Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv);
                        } else {
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer3);
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                            $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                            $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                        }
                        Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                        int i = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        int i2 = ((0 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 599195447, "C1133@47901L294,1140@48208L123,1143@48344L288:TimePicker.kt#uh7d8r");
                        TimePickerKt.m2740TimeSelectorSAnMeKU(SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3568getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3567getTimeSelectorContainerHeightD9Ej5fM()), TimePickerKt.getHourForDisplay(timePickerState), timePickerState, TimePickerSelectionMode.INSTANCE.m2769getHouryecRtBI(), timePickerColors, $composer3, 3078);
                        TimePickerKt.DisplaySeparator(SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, TimePickerKt.DisplaySeparatorWidth, TimePickerTokens.INSTANCE.m3564getPeriodSelectorVerticalContainerHeightD9Ej5fM()), $composer3, 6);
                        TimePickerKt.m2740TimeSelectorSAnMeKU(SizeKt.m728sizeVpY3zN4(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3568getTimeSelectorContainerWidthD9Ej5fM(), TimePickerTokens.INSTANCE.m3567getTimeSelectorContainerHeightD9Ej5fM()), timePickerState.getMinute(), timePickerState, TimePickerSelectionMode.INSTANCE.m2770getMinuteyecRtBI(), timePickerColors, $composer3, 3078);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }, $composer2, 54), $composer2, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockDisplayNumbers.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.ClockDisplayNumbers(state, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalPeriodToggle(Modifier modifier, TimePickerState state, TimePickerColors colors, Composer $composer, final int $changed) {
        TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1 value$iv;
        final Modifier modifier2;
        final TimePickerState state2;
        final TimePickerColors colors2;
        Composer $composer2 = $composer.startRestartGroup(1261215927);
        ComposerKt.sourceInformation($composer2, "C(HorizontalPeriodToggle)P(1,2)1160@48810L1014,1188@49871L5,1190@49902L206:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(colors) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1261215927, $dirty, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1159)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2071625362, "CC(remember):TimePicker.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo34measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> list, long constraints) {
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = list.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "Spacer")) {
                                Measurable spacer = (Measurable) item$iv$iv;
                                final Placeable spacerPlaceable = spacer.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : $this$MeasurePolicy.mo361roundToPx0680j_4(TimePickerTokens.INSTANCE.m3563getPeriodSelectorOutlineWidthD9Ej5fM()), (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0));
                                List target$iv = new ArrayList(list.size());
                                int index$iv$iv2 = 0;
                                int size2 = list.size();
                                while (index$iv$iv2 < size2) {
                                    Measurable measurable = list.get(index$iv$iv2);
                                    Measurable it2 = measurable;
                                    Measurable spacer2 = spacer;
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "Spacer")) {
                                        target$iv.add(measurable);
                                    }
                                    index$iv$iv2++;
                                    spacer = spacer2;
                                }
                                List $this$fastMap$iv = target$iv;
                                int $i$f$fastMap = 0;
                                List target$iv2 = new ArrayList($this$fastMap$iv.size());
                                int index$iv$iv3 = 0;
                                int size3 = $this$fastMap$iv.size();
                                while (index$iv$iv3 < size3) {
                                    Measurable item = (Measurable) $this$fastMap$iv.get(index$iv$iv3);
                                    target$iv2.add(item.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : Constraints.m6636getMaxWidthimpl(constraints) / 2, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0)));
                                    index$iv$iv3++;
                                    $this$fastMap$iv = $this$fastMap$iv;
                                    $i$f$fastMap = $i$f$fastMap;
                                }
                                final List items = target$iv2;
                                return MeasureScope.CC.layout$default($this$MeasurePolicy, Constraints.m6636getMaxWidthimpl(constraints), Constraints.m6635getMaxHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                                        Placeable.PlacementScope.place$default($this$layout, items.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, items.get(1), items.get(0).getWidth(), 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, spacerPlaceable, items.get(0).getWidth() - (spacerPlaceable.getWidth() / 2), 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), $composer2, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape shape = (CornerBasedShape) value;
            modifier2 = modifier;
            state2 = state;
            colors2 = colors;
            PeriodToggleImpl(modifier2, state2, colors2, measurePolicy, ShapesKt.start(shape), ShapesKt.end(shape), $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            state2 = state;
            colors2 = colors;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.HorizontalPeriodToggle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.HorizontalPeriodToggle(modifier2, state2, colors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalPeriodToggle(Modifier modifier, TimePickerState state, TimePickerColors colors, Composer $composer, final int $changed) {
        TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1 value$iv;
        final Modifier modifier2;
        final TimePickerState state2;
        final TimePickerColors colors2;
        Composer $composer2 = $composer.startRestartGroup(-1898918107);
        ComposerKt.sourceInformation($composer2, "C(VerticalPeriodToggle)P(1,2)1206@50268L1021,1234@51336L5,1236@51367L207:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= ($changed & 64) == 0 ? $composer2.changed(state) : $composer2.changedInstance(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(colors) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1898918107, $dirty, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1205)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 1491514731, "CC(remember):TimePicker.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo34measure3p2s80s(MeasureScope $this$MeasurePolicy, List<? extends Measurable> list, long constraints) {
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Object item$iv$iv = list.get(index$iv$iv);
                            Measurable it = (Measurable) item$iv$iv;
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(it), "Spacer")) {
                                Measurable spacer = (Measurable) item$iv$iv;
                                final Placeable spacerPlaceable = spacer.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : $this$MeasurePolicy.mo361roundToPx0680j_4(TimePickerTokens.INSTANCE.m3563getPeriodSelectorOutlineWidthD9Ej5fM())));
                                List target$iv = new ArrayList(list.size());
                                int index$iv$iv2 = 0;
                                int size2 = list.size();
                                while (index$iv$iv2 < size2) {
                                    Measurable measurable = list.get(index$iv$iv2);
                                    Measurable it2 = measurable;
                                    Measurable spacer2 = spacer;
                                    if (!Intrinsics.areEqual(LayoutIdKt.getLayoutId(it2), "Spacer")) {
                                        target$iv.add(measurable);
                                    }
                                    index$iv$iv2++;
                                    spacer = spacer2;
                                }
                                List $this$fastMap$iv = target$iv;
                                int $i$f$fastMap = 0;
                                List target$iv2 = new ArrayList($this$fastMap$iv.size());
                                int index$iv$iv3 = 0;
                                int size3 = $this$fastMap$iv.size();
                                while (index$iv$iv3 < size3) {
                                    Measurable item = (Measurable) $this$fastMap$iv.get(index$iv$iv3);
                                    target$iv2.add(item.mo5535measureBRTryo0(Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : Constraints.m6635getMaxHeightimpl(constraints) / 2)));
                                    index$iv$iv3++;
                                    $this$fastMap$iv = $this$fastMap$iv;
                                    $i$f$fastMap = $i$f$fastMap;
                                }
                                final List items = target$iv2;
                                return MeasureScope.CC.layout$default($this$MeasurePolicy, Constraints.m6636getMaxWidthimpl(constraints), Constraints.m6635getMaxHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                        invoke2(placementScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(Placeable.PlacementScope $this$layout) {
                                        Placeable.PlacementScope.place$default($this$layout, items.get(0), 0, 0, 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, items.get(1), 0, items.get(0).getHeight(), 0.0f, 4, null);
                                        Placeable.PlacementScope.place$default($this$layout, spacerPlaceable, 0, items.get(0).getHeight() - (spacerPlaceable.getHeight() / 2), 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), $composer2, 6);
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
            CornerBasedShape shape = (CornerBasedShape) value;
            modifier2 = modifier;
            state2 = state;
            colors2 = colors;
            PeriodToggleImpl(modifier2, state2, colors2, measurePolicy, ShapesKt.top(shape), ShapesKt.bottom(shape), $composer2, ($dirty & 14) | 3072 | ($dirty & 112) | ($dirty & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            state2 = state;
            colors2 = colors;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.VerticalPeriodToggle.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.VerticalPeriodToggle(modifier2, state2, colors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0218  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void PeriodToggleImpl(final androidx.compose.ui.Modifier r39, final androidx.compose.material3.TimePickerState r40, final androidx.compose.material3.TimePickerColors r41, final androidx.compose.ui.layout.MeasurePolicy r42, final androidx.compose.ui.graphics.Shape r43, final androidx.compose.ui.graphics.Shape r44, androidx.compose.runtime.Composer r45, final int r46) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.PeriodToggleImpl(androidx.compose.ui.Modifier, androidx.compose.material3.TimePickerState, androidx.compose.material3.TimePickerColors, androidx.compose.ui.layout.MeasurePolicy, androidx.compose.ui.graphics.Shape, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ToggleItem(final boolean checked, final Shape shape, final Function0<Unit> function0, final TimePickerColors colors, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed) {
        Shape shape2;
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1937408098);
        ComposerKt.sourceInformation($composer3, "C(ToggleItem)P(!1,4,3)1310@53677L22,1316@53868L124,1308@53569L429:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(checked) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            shape2 = shape;
            $dirty |= $composer3.changed(shape2) ? 32 : 16;
        } else {
            shape2 = shape;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(colors) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changedInstance(function3) ? 16384 : 8192;
        }
        if (($dirty & 9363) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1937408098, $dirty, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1304)");
            }
            long contentColor = colors.m2732periodSelectorContentColorvNxB06k$material3_release(checked);
            long containerColor = colors.m2731periodSelectorContainerColorvNxB06k$material3_release(checked);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(Modifier.INSTANCE, checked ? 0.0f : 1.0f), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart($composer3, -857429536, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = ($dirty & 14) == 4;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ToggleItem$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.setSelected($this$semantics, checked);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ButtonKt.TextButton(function0, SemanticsModifierKt.semantics$default(modifierFillMaxSize$default, false, (Function1) value$iv, 1, null), false, shape2, ButtonDefaults.INSTANCE.m1838textButtonColorsro_MJ88(containerColor, contentColor, 0L, 0L, $composer3, 24576, 12), null, null, PaddingKt.m674PaddingValues0680j_4(Dp.m6693constructorimpl(0)), null, function3, $composer3, (($dirty >> 6) & 14) | 12582912 | (($dirty << 6) & 7168) | (($dirty << 15) & 1879048192), 356);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ToggleItem.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.ToggleItem(checked, shape, function0, colors, function3, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DisplaySeparator(final Modifier modifier, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(2100674302);
        ComposerKt.sourceInformation($composer2, "C(DisplaySeparator)1326@54104L7,1335@54375L172:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2100674302, $dirty, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1324)");
            }
            ProvidableCompositionLocal<TextStyle> localTextStyle = TextKt.getLocalTextStyle();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localTextStyle);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextStyle style = TextStyle.m6159copyp1EtxEg$default((TextStyle) objConsume, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.INSTANCE.m6550getCentere0LSkKk(), 0, 0L, null, null, new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m6527getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m6539getBothEVpEnUU(), null), 0, 0, null, 15695871, null);
            Modifier modifier$iv = SemanticsModifierKt.clearAndSetSemantics(modifier, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                }
            });
            Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -789568360, "C1336@54520L5,1336@54471L70:TimePicker.kt#uh7d8r");
            TextKt.m2711Text4IGK_g(":", (Modifier) null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), $composer2, 6), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, style, $composer2, 6, 0, 65530);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.DisplaySeparator.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    TimePickerKt.DisplaySeparator(modifier, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TimeSelector-SAnMeKU, reason: not valid java name */
    public static final void m2740TimeSelectorSAnMeKU(final Modifier modifier, final int value, final TimePickerState state, final int selection, final TimePickerColors colors, Composer $composer, final int $changed) {
        int iM2922constructorimpl;
        Object value$iv;
        Composer $composer2;
        Composer $composer3 = $composer.startRestartGroup(-1148055889);
        ComposerKt.sourceInformation($composer3, "C(TimeSelector)P(1,4,3,2:c#material3.TimePickerSelectionMode)1351@54864L214,1363@55302L124,1373@55637L5,1367@55446L117,1375@55682L497,1361@55218L961:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(modifier) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(value) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer3.changed(state) : $composer3.changedInstance(state) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changed(selection) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer3.changed(colors) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9363) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1148055889, $dirty2, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1348)");
            }
            boolean selected = TimePickerSelectionMode.m2765equalsimpl0(state.mo1778getSelectionyecRtBI(), selection);
            if (TimePickerSelectionMode.m2765equalsimpl0(selection, TimePickerSelectionMode.INSTANCE.m2769getHouryecRtBI())) {
                Strings.Companion companion = Strings.INSTANCE;
                iM2922constructorimpl = Strings.m2922constructorimpl(R.string.m3c_time_picker_hour_selection);
            } else {
                Strings.Companion companion2 = Strings.INSTANCE;
                iM2922constructorimpl = Strings.m2922constructorimpl(R.string.m3c_time_picker_minute_selection);
            }
            final String selectorContentDescription = Strings_androidKt.m2992getString2EP1pXo(iM2922constructorimpl, $composer3, 0);
            long containerColor = colors.m2733timeSelectorContainerColorvNxB06k$material3_release(selected);
            final long contentColor = colors.m2734timeSelectorContentColorvNxB06k$material3_release(selected);
            ComposerKt.sourceInformationMarkerStart($composer3, 1840519339, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = $composer3.changed(selectorContentDescription);
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        SemanticsPropertiesKt.m5975setRolekuIjeqM($this$semantics, Role.INSTANCE.m5960getRadioButtono7Vup1c());
                        SemanticsPropertiesKt.setContentDescription($this$semantics, selectorContentDescription);
                    }
                };
                $composer3.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier, true, (Function1) value$iv);
            Shape value2 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), $composer3, 6);
            ComposerKt.sourceInformationMarkerStart($composer3, 1840523940, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv2 = (($dirty2 & 7168) == 2048) | (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer3.changedInstance(state)));
            Object value$iv2 = $composer3.rememberedValue();
            if (invalid$iv2 || value$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        if (!TimePickerSelectionMode.m2765equalsimpl0(selection, state.mo1778getSelectionyecRtBI())) {
                            state.mo1779setSelection6_8s6DQ(selection);
                        }
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            SurfaceKt.m2562Surfaced85dljk(selected, (Function0<Unit>) value$iv2, modifierSemantics, false, value2, containerColor, 0L, 0.0f, 0.0f, (BorderStroke) null, (MutableInteractionSource) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1477282471, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer4, int $changed2) {
                    ComposerKt.sourceInformation($composer4, "C1377@55734L152,1383@55896L277:TimePicker.kt#uh7d8r");
                    if (($changed2 & 3) == 2 && $composer4.getSkipping()) {
                        $composer4.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1477282471, $changed2, -1, "androidx.compose.material3.TimeSelector.<anonymous> (TimePicker.kt:1376)");
                    }
                    final String valueContentDescription = TimePickerKt.m2748numberContentDescriptiondSwYdS4(selection, state.getIs24hour(), value, $composer4, 0);
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getCenter();
                    int i = value;
                    long j = contentColor;
                    ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Modifier modifier$iv = Modifier.INSTANCE;
                    MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                    int $changed$iv$iv = (48 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer4, 0);
                    CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv);
                    Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer4.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer4.startReusableNode();
                    if ($composer4.getInserting()) {
                        $composer4.createNode(factory$iv$iv$iv);
                    } else {
                        $composer4.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer4);
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                        $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                        $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
                    }
                    Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i3 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer4, 396102018, "C1385@56003L48,1384@55951L212:TimePicker.kt#uh7d8r");
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart($composer4, 705515645, "CC(remember):TimePicker.kt#9igjgp");
                    boolean invalid$iv3 = $composer4.changed(valueContentDescription);
                    Object value$iv3 = $composer4.rememberedValue();
                    if (invalid$iv3 || value$iv3 == Composer.INSTANCE.getEmpty()) {
                        value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$3$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                SemanticsPropertiesKt.setContentDescription($this$semantics, valueContentDescription);
                            }
                        };
                        $composer4.updateRememberedValue(value$iv3);
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    TextKt.m2711Text4IGK_g(CalendarLocale_jvmKt.toLocalString$default(i, 2, 0, false, 6, null), SemanticsModifierKt.semantics$default(companion3, false, (Function1) value$iv3, 1, null), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131064);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer3, 54), $composer3, 0, 48, 1992);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$TimeSelector$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.m2740TimeSelectorSAnMeKU(modifier, value, state, selection, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    public static final void ClockFace(final AnalogTimePickerState state, final TimePickerColors colors, final boolean autoSwitchToMinute, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1170157036);
        ComposerKt.sourceInformation($composer2, "C(ClockFace)P(2,1)1521@60272L2018,1513@59878L2412:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(colors) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(autoSwitchToMinute) ? 256 : 128;
        }
        if (($dirty & 147) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1170157036, $dirty, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1512)");
            }
            CrossfadeKt.Crossfade(state.getClockFaceValues(), drawSelector(SizeKt.m726size3ABfNKs(BackgroundKt.m229backgroundbw27NRU(Modifier.INSTANCE, colors.getClockDialColor(), RoundedCornerShapeKt.getCircleShape()).then(new ClockDialModifier(state, autoSwitchToMinute, state.mo1778getSelectionyecRtBI(), null)), TimePickerTokens.INSTANCE.m3556getClockDialContainerSizeD9Ej5fM()), state, colors), AnimationSpecKt.tween$default(ComposerKt.invocationKey, 0, null, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-1022006568, true, new Function3<IntList, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(IntList intList, Composer composer, Integer num) {
                    invoke(intList, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final IntList screen, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C1525@60456L1828,1522@60292L1992:TimePicker.kt#uh7d8r");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1022006568, $changed2, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1522)");
                    }
                    Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(SizeKt.m726size3ABfNKs(Modifier.INSTANCE, TimePickerTokens.INSTANCE.m3556getClockDialContainerSizeD9Ej5fM()), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                            SemanticsPropertiesKt.selectableGroup($this$semantics);
                        }
                    }, 1, null);
                    float f = TimePickerKt.OuterCircleSizeRadius;
                    final TimePickerColors timePickerColors = colors;
                    final AnalogTimePickerState analogTimePickerState = state;
                    final boolean z = autoSwitchToMinute;
                    TimePickerKt.m2737CircularLayoutuFdPcIQ(modifierSemantics$default, f, ComposableLambdaKt.rememberComposableLambda(-320307952, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer4, int $changed3) {
                            ComposerKt.sourceInformation($composer4, "C1528@60589L1685,1526@60470L1804:TimePicker.kt#uh7d8r");
                            if (($changed3 & 3) != 2 || !$composer4.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-320307952, $changed3, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous> (TimePicker.kt:1526)");
                                }
                                ProvidedValue<Color> providedValueProvides = ContentColorKt.getLocalContentColor().provides(Color.m4177boximpl(timePickerColors.m2715clockDialContentColorvNxB06k$material3_release(false)));
                                final IntList intList = screen;
                                final AnalogTimePickerState analogTimePickerState2 = analogTimePickerState;
                                final boolean z2 = z;
                                CompositionLocalKt.CompositionLocalProvider(providedValueProvides, ComposableLambdaKt.rememberComposableLambda(1992872400, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                        invoke(composer, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer $composer5, int $changed4) {
                                        int outerValue;
                                        boolean z3;
                                        Object value$iv;
                                        Composer composer = $composer5;
                                        ComposerKt.sourceInformation(composer, "C1551@61690L552,1545@61343L899:TimePicker.kt#uh7d8r");
                                        if (($changed4 & 3) != 2 || !composer.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1992872400, $changed4, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1529)");
                                            }
                                            composer.startReplaceGroup(1547046870);
                                            ComposerKt.sourceInformation(composer, "*1537@61008L36,1536@60943L271");
                                            int size = intList.getSize();
                                            AnalogTimePickerState analogTimePickerState3 = analogTimePickerState2;
                                            IntList intList2 = intList;
                                            boolean z4 = z2;
                                            int i = 0;
                                            while (i < size) {
                                                final int index = i;
                                                if (!analogTimePickerState3.getIs24hour() || TimePickerSelectionMode.m2765equalsimpl0(analogTimePickerState3.mo1778getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2770getMinuteyecRtBI())) {
                                                    outerValue = intList2.get(index);
                                                } else {
                                                    outerValue = intList2.get(index) % 12;
                                                }
                                                Modifier.Companion companion = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(composer, 707420712, "CC(remember):TimePicker.kt#9igjgp");
                                                boolean invalid$iv = composer.changed(index);
                                                Object it$iv = $composer5.rememberedValue();
                                                if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                                                    z3 = z4;
                                                    value$iv = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$1$1$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                            invoke2(semanticsPropertyReceiver);
                                                            return Unit.INSTANCE;
                                                        }

                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                                            SemanticsPropertiesKt.setTraversalIndex($this$semantics, index);
                                                        }
                                                    };
                                                    $composer5.updateRememberedValue(value$iv);
                                                } else {
                                                    z3 = z4;
                                                    value$iv = it$iv;
                                                }
                                                ComposerKt.sourceInformationMarkerEnd(composer);
                                                int outerValue2 = outerValue;
                                                Composer composer2 = composer;
                                                TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv, 1, null), analogTimePickerState3, outerValue2, z3, composer2, 0);
                                                composer = composer2;
                                                i++;
                                                z4 = z3;
                                            }
                                            composer.endReplaceGroup();
                                            if (TimePickerSelectionMode.m2765equalsimpl0(analogTimePickerState2.mo1778getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2769getHouryecRtBI()) && analogTimePickerState2.getIs24hour()) {
                                                Modifier modifierM229backgroundbw27NRU = BackgroundKt.m229backgroundbw27NRU(SizeKt.m726size3ABfNKs(LayoutIdKt.layoutId(Modifier.INSTANCE, LayoutId.InnerCircle), TimePickerTokens.INSTANCE.m3556getClockDialContainerSizeD9Ej5fM()), Color.INSTANCE.m4222getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
                                                float f2 = TimePickerKt.InnerCircleRadius;
                                                final AnalogTimePickerState analogTimePickerState4 = analogTimePickerState2;
                                                final boolean z5 = z2;
                                                TimePickerKt.m2737CircularLayoutuFdPcIQ(modifierM229backgroundbw27NRU, f2, ComposableLambdaKt.rememberComposableLambda(-205464413, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.1.2.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(2);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                                        invoke(composer3, num.intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer $composer6, int $changed5) {
                                                        Object value$iv2;
                                                        Composer composer3 = $composer6;
                                                        ComposerKt.sourceInformation(composer3, "C*1556@61951L41,1554@61842L352:TimePicker.kt#uh7d8r");
                                                        if (($changed5 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-205464413, $changed5, -1, "androidx.compose.material3.ClockFace.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TimePicker.kt:1552)");
                                                            }
                                                            int size2 = TimePickerKt.ExtraHours.getSize();
                                                            AnalogTimePickerState analogTimePickerState5 = analogTimePickerState4;
                                                            boolean z6 = z5;
                                                            int i2 = 0;
                                                            while (i2 < size2) {
                                                                final int index2 = i2;
                                                                int innerValue = TimePickerKt.ExtraHours.get(index2);
                                                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                                                ComposerKt.sourceInformationMarkerStart(composer3, 1677472780, "CC(remember):TimePicker.kt#9igjgp");
                                                                boolean invalid$iv2 = composer3.changed(index2);
                                                                Object it$iv2 = $composer6.rememberedValue();
                                                                if (invalid$iv2 || it$iv2 == Composer.INSTANCE.getEmpty()) {
                                                                    value$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockFace$1$2$1$2$1$1$1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                                            invoke2(semanticsPropertyReceiver);
                                                                            return Unit.INSTANCE;
                                                                        }

                                                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                                        public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                                                                            SemanticsPropertiesKt.setTraversalIndex($this$semantics, 12.0f + index2);
                                                                        }
                                                                    };
                                                                    $composer6.updateRememberedValue(value$iv2);
                                                                } else {
                                                                    value$iv2 = it$iv2;
                                                                }
                                                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                                                TimePickerKt.ClockText(SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv2, 1, null), analogTimePickerState5, innerValue, z6, composer3, 0);
                                                                i2++;
                                                                composer3 = $composer6;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }, composer, 54), composer, 432, 0);
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer.skipToGroupEnd();
                                    }
                                }, $composer4, 54), $composer4, ProvidedValue.$stable | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer4.skipToGroupEnd();
                        }
                    }, $composer3, 54), $composer3, 432, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockFace.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) {
                    TimePickerKt.ClockFace(state, colors, autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    private static final Modifier drawSelector(Modifier $this$drawSelector, final AnalogTimePickerState state, final TimePickerColors colors) {
        return DrawModifierKt.drawWithContent($this$drawSelector, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt.drawSelector.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope $this$drawWithContent) {
                long selectorOffsetPx = OffsetKt.Offset($this$drawWithContent.mo367toPx0680j_4(DpOffset.m6754getXD9Ej5fM(TimePickerKt.getSelectorPos(state))), $this$drawWithContent.mo367toPx0680j_4(DpOffset.m6756getYD9Ej5fM(TimePickerKt.getSelectorPos(state))));
                float selectorRadius = $this$drawWithContent.mo367toPx0680j_4(TimePickerTokens.INSTANCE.m3558getClockDialSelectorHandleContainerSizeD9Ej5fM()) / TimePickerKt.SeparatorZIndex;
                long selectorColor = colors.getSelectorColor();
                DrawScope.CC.m4734drawCircleVaOC9Bg$default($this$drawWithContent, Color.INSTANCE.m4213getBlack0d7_KjU(), selectorRadius, selectorOffsetPx, 0.0f, null, null, BlendMode.INSTANCE.m4102getClear0nO6VwU(), 56, null);
                $this$drawWithContent.drawContent();
                DrawScope.CC.m4734drawCircleVaOC9Bg$default($this$drawWithContent, selectorColor, selectorRadius, selectorOffsetPx, 0.0f, null, null, BlendMode.INSTANCE.m4130getXor0nO6VwU(), 56, null);
                float strokeWidth = $this$drawWithContent.mo367toPx0680j_4(TimePickerTokens.INSTANCE.m3559getClockDialSelectorTrackContainerWidthD9Ej5fM());
                long lineLength = Offset.m3949minusMKHz9U(selectorOffsetPx, OffsetKt.Offset(((float) Math.cos(state.getCurrentAngle())) * selectorRadius, ((float) Math.sin(state.getCurrentAngle())) * selectorRadius));
                DrawScope.CC.m4739drawLineNGM6Ib0$default($this$drawWithContent, selectorColor, androidx.compose.ui.geometry.SizeKt.m4024getCenteruvyYCjk($this$drawWithContent.mo4662getSizeNHjbRc()), lineLength, strokeWidth, 0, null, 0.0f, null, BlendMode.INSTANCE.m4129getSrcOver0nO6VwU(), 240, null);
                DrawScope.CC.m4734drawCircleVaOC9Bg$default($this$drawWithContent, selectorColor, $this$drawWithContent.mo367toPx0680j_4(TimePickerTokens.INSTANCE.m3557getClockDialSelectorCenterContainerSizeD9Ej5fM()) / TimePickerKt.SeparatorZIndex, androidx.compose.ui.geometry.SizeKt.m4024getCenteruvyYCjk($this$drawWithContent.mo4662getSizeNHjbRc()), 0.0f, null, null, 0, 120, null);
                DrawScope.CC.m4734drawCircleVaOC9Bg$default($this$drawWithContent, colors.m2715clockDialContentColorvNxB06k$material3_release(true), selectorRadius, selectorOffsetPx, 0.0f, null, null, BlendMode.INSTANCE.m4112getDstOver0nO6VwU(), 56, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText(Modifier modifier, final AnalogTimePickerState state, final int value, final boolean autoSwitchToMinute, Composer $composer, final int $changed) {
        Modifier modifier2;
        boolean z;
        Object value$iv;
        String str;
        Object value$iv2;
        Object value$iv$iv;
        final float maxDist;
        Modifier modifier3;
        final boolean selected;
        final CoroutineScope scope;
        Alignment alignment;
        String text;
        boolean z2;
        Object value$iv3;
        Function0 factory$iv$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-206784607);
        ComposerKt.sourceInformation($composer2, "C(ClockText)P(1,2,3)1639@64421L5,*1640@64463L7,1641@64513L40,1642@64578L43,1643@64638L24,1645@64700L142,1665@65318L163,1670@65563L503,1659@65093L1182:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(state) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(value) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            z = autoSwitchToMinute;
            $dirty |= $composer2.changed(z) ? 2048 : 1024;
        } else {
            z = autoSwitchToMinute;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 1171) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-206784607, $dirty2, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1638)");
            }
            TextStyle style = TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), $composer2, 6);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density $this$ClockText_u24lambda_u2427 = (Density) objConsume;
            float maxDist2 = $this$ClockText_u24lambda_u2427.mo367toPx0680j_4(MaxDistance);
            ComposerKt.sourceInformationMarkerStart($composer2, 297230880, "CC(remember):TimePicker.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3934boximpl(Offset.INSTANCE.m3961getZeroF1C5BW0()), null, 2, null);
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            final MutableState center$delegate = (MutableState) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 297232963, "CC(remember):TimePicker.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.INSTANCE.getEmpty()) {
                str = "CC(remember):TimePicker.kt#9igjgp";
                value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(IntOffset.m6816boximpl(IntOffset.INSTANCE.m6835getZeronOccac()), null, 2, null);
                $composer2.updateRememberedValue(value$iv2);
            } else {
                str = "CC(remember):TimePicker.kt#9igjgp";
                value$iv2 = it$iv2;
            }
            final MutableState parentCenter$delegate = (MutableState) value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, -954363344, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2));
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CoroutineScope scope2 = wrapper$iv.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final String contentDescription = m2748numberContentDescriptiondSwYdS4(state.mo1778getSelectionyecRtBI(), state.getIs24hour(), value, $composer2, $dirty2 & 896);
            String str2 = str;
            String text2 = CalendarLocale_jvmKt.toLocalString$default(value, 0, 0, false, 7, null);
            boolean selected2 = TimePickerSelectionMode.m2765equalsimpl0(state.mo1778getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2770getMinuteyecRtBI()) ? Intrinsics.areEqual(CalendarLocale_jvmKt.toLocalString$default(state.getMinute(), 0, 0, false, 7, null), text2) : Intrinsics.areEqual(CalendarLocale_jvmKt.toLocalString$default(state.getHour(), 0, 0, false, 7, null), text2);
            Alignment center = Alignment.INSTANCE.getCenter();
            Modifier modifierM726size3ABfNKs = SizeKt.m726size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier2), MinimumInteractiveSize);
            ComposerKt.sourceInformationMarkerStart($composer2, 297256763, str2);
            Object value$iv4 = $composer2.rememberedValue();
            if (value$iv4 == Composer.INSTANCE.getEmpty()) {
                value$iv4 = (Function1) new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LayoutCoordinates layoutCoordinates) {
                        invoke2(layoutCoordinates);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LayoutCoordinates it) {
                        MutableState<IntOffset> mutableState = parentCenter$delegate;
                        LayoutCoordinates parentCoordinates = it.getParentCoordinates();
                        TimePickerKt.ClockText$lambda$33(mutableState, parentCoordinates != null ? IntSizeKt.m6873getCenterozmzZPI(parentCoordinates.mo5537getSizeYbymL2g()) : IntOffset.INSTANCE.m6835getZeronOccac());
                        TimePickerKt.ClockText$lambda$30(center$delegate, LayoutCoordinatesKt.boundsInParent(it).m3975getCenterF1C5BW0());
                    }
                };
                $composer2.updateRememberedValue(value$iv4);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierFocusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifierM726size3ABfNKs, (Function1) value$iv4), false, null, 3, null);
            ComposerKt.sourceInformationMarkerStart($composer2, 297264943, str2);
            boolean invalid$iv = $composer2.changedInstance(scope2) | $composer2.changedInstance(state) | $composer2.changed(maxDist2) | (($dirty2 & 7168) == 2048) | $composer2.changed(selected2);
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.INSTANCE.getEmpty()) {
                maxDist = maxDist2;
                final boolean z3 = z;
                modifier3 = modifierFocusable$default;
                selected = selected2;
                scope = scope2;
                alignment = center;
                text = text2;
                z2 = true;
                value$iv3 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$semantics) {
                        final CoroutineScope coroutineScope = scope;
                        final AnalogTimePickerState analogTimePickerState = state;
                        final float f = maxDist;
                        final boolean z4 = z3;
                        final MutableState<Offset> mutableState = center$delegate;
                        final MutableState<IntOffset> mutableState2 = parentCenter$delegate;
                        SemanticsPropertiesKt.onClick$default($this$semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$2$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* compiled from: TimePicker.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                            @DebugMetadata(c = "androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1", f = "TimePicker.kt", i = {}, l = {1674}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: androidx.compose.material3.TimePickerKt$ClockText$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ boolean $autoSwitchToMinute;
                                final /* synthetic */ MutableState<Offset> $center$delegate;
                                final /* synthetic */ float $maxDist;
                                final /* synthetic */ MutableState<IntOffset> $parentCenter$delegate;
                                final /* synthetic */ AnalogTimePickerState $state;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C01271(AnalogTimePickerState analogTimePickerState, float f, boolean z, MutableState<Offset> mutableState, MutableState<IntOffset> mutableState2, Continuation<? super C01271> continuation) {
                                    super(2, continuation);
                                    this.$state = analogTimePickerState;
                                    this.$maxDist = f;
                                    this.$autoSwitchToMinute = z;
                                    this.$center$delegate = mutableState;
                                    this.$parentCenter$delegate = mutableState2;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C01271(this.$state, this.$maxDist, this.$autoSwitchToMinute, this.$center$delegate, this.$parentCenter$delegate, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C01271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object $result) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    switch (this.label) {
                                        case 0:
                                            ResultKt.throwOnFailure($result);
                                            this.label = 1;
                                            if (TimePickerKt.m2749onTaprOwcSBo(this.$state, Offset.m3945getXimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate)), Offset.m3946getYimpl(TimePickerKt.ClockText$lambda$29(this.$center$delegate)), this.$maxDist, this.$autoSwitchToMinute, TimePickerKt.ClockText$lambda$32(this.$parentCenter$delegate), this) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        case 1:
                                            ResultKt.throwOnFailure($result);
                                            break;
                                        default:
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Boolean invoke() {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01271(analogTimePickerState, f, z4, mutableState, mutableState2, null), 3, null);
                                return true;
                            }
                        }, 1, null);
                        SemanticsPropertiesKt.setSelected($this$semantics, selected);
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
            } else {
                modifier3 = modifierFocusable$default;
                scope = scope2;
                alignment = center;
                maxDist = maxDist2;
                selected = selected2;
                value$iv3 = it$iv3;
                text = text2;
                z2 = true;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier3, z2, (Function1) value$iv3);
            ComposerKt.sourceInformationMarkerStart($composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(alignment, false);
            int $changed$iv$iv = (48 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifierSemantics);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.m3678constructorimpl($composer2);
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv$iv))) {
                $this$Layout_u24lambda_u240$iv$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv$iv));
                $this$Layout_u24lambda_u240$iv$iv.apply(Integer.valueOf(compositeKeyHash$iv$iv), block$iv$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.INSTANCE.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1481062706, "C1688@66158L48,1686@66083L186:TimePicker.kt#uh7d8r");
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, 879062471, str2);
            boolean invalid$iv2 = $composer2.changed(contentDescription);
            Object value$iv5 = $composer2.rememberedValue();
            if (invalid$iv2 || value$iv5 == Composer.INSTANCE.getEmpty()) {
                value$iv5 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.TimePickerKt$ClockText$3$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        invoke2(semanticsPropertyReceiver);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(SemanticsPropertyReceiver $this$clearAndSetSemantics) {
                        SemanticsPropertiesKt.setContentDescription($this$clearAndSetSemantics, contentDescription);
                    }
                };
                $composer2.updateRememberedValue(value$iv5);
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            TextKt.m2711Text4IGK_g(text, SemanticsModifierKt.clearAndSetSemantics(companion, (Function1) value$iv5), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, style, $composer2, 0, 0, 65532);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt.ClockText.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    TimePickerKt.ClockText(modifier4, state, value, autoSwitchToMinute, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$29(MutableState<Offset> mutableState) {
        MutableState<Offset> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText$lambda$30(MutableState<Offset> mutableState, long value) {
        mutableState.setValue(Offset.m3934boximpl(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long ClockText$lambda$32(MutableState<IntOffset> mutableState) {
        MutableState<IntOffset> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().getPackedValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ClockText$lambda$33(MutableState<IntOffset> mutableState, long value) {
        mutableState.setValue(IntOffset.m6816boximpl(value));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071 A[Catch: IllegalArgumentException -> 0x00cf, NumberFormatException | IllegalArgumentException -> 0x00d1, TRY_ENTER, TryCatch #6 {NumberFormatException | IllegalArgumentException -> 0x00d1, blocks: (B:18:0x0049, B:32:0x007d, B:41:0x00a1, B:44:0x00af, B:40:0x009e, B:29:0x0071), top: B:59:0x0049 }] */
    /* renamed from: timeInputOnChange-z7XvuPQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2750timeInputOnChangez7XvuPQ(int r10, androidx.compose.material3.TimePickerState r11, androidx.compose.ui.text.input.TextFieldValue r12, androidx.compose.ui.text.input.TextFieldValue r13, int r14, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r15) throws java.lang.NumberFormatException {
        /*
            java.lang.String r0 = r12.getText()
            java.lang.String r1 = r13.getText()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L12
            r15.invoke(r12)
            return
        L12:
            java.lang.String r0 = r12.getText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L22
            r0 = 1
            goto L23
        L22:
            r0 = 0
        L23:
            if (r0 == 0) goto L48
            androidx.compose.material3.TimePickerSelectionMode$Companion r0 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE
            int r0 = r0.m2769getHouryecRtBI()
            boolean r0 = androidx.compose.material3.TimePickerSelectionMode.m2765equalsimpl0(r10, r0)
            if (r0 == 0) goto L35
            r11.setHour(r2)
            goto L38
        L35:
            r11.setMinute(r2)
        L38:
            r8 = 6
            r9 = 0
            java.lang.String r4 = ""
            r5 = 0
            r7 = 0
            r3 = r12
            androidx.compose.ui.text.input.TextFieldValue r12 = androidx.compose.ui.text.input.TextFieldValue.m6391copy3r_uNRQ$default(r3, r4, r5, r7, r8, r9)
            r15.invoke(r12)
            return
        L48:
            r3 = r12
            java.lang.String r12 = r3.getText()     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            int r12 = r12.length()     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            r0 = 3
            if (r12 != r0) goto L71
            long r4 = r3.getSelection()     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            int r12 = androidx.compose.ui.text.TextRange.m6146getStartimpl(r4)     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            if (r12 != r1) goto L71
            java.lang.String r12 = r3.getText()     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            char r12 = r12.charAt(r2)     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            int r12 = kotlin.text.CharsKt.digitToInt(r12)     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            goto L79
        L6b:
            r0 = move-exception
            goto L6e
        L6d:
            r0 = move-exception
        L6e:
            r1 = r3
            goto Ld3
        L71:
            java.lang.String r12 = r3.getText()     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            int r12 = java.lang.Integer.parseInt(r12)     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
        L79:
            if (r12 > r14) goto Lcd
            androidx.compose.material3.TimePickerSelectionMode$Companion r0 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            int r0 = r0.m2769getHouryecRtBI()     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            boolean r0 = androidx.compose.material3.TimePickerSelectionMode.m2765equalsimpl0(r10, r0)     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            if (r0 == 0) goto L9e
            r11.setHour(r12)     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            if (r12 <= r1) goto La1
            boolean r0 = r11.getIs24hour()     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            if (r0 != 0) goto La1
            androidx.compose.material3.TimePickerSelectionMode$Companion r0 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            int r0 = r0.m2770getMinuteyecRtBI()     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            r11.mo1779setSelection6_8s6DQ(r0)     // Catch: java.lang.IllegalArgumentException -> L6b java.lang.NumberFormatException -> L6d
            goto La1
        L9e:
            r11.setMinute(r12)     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
        La1:
            java.lang.String r0 = r3.getText()     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            int r0 = r0.length()     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            r1 = 2
            if (r0 > r1) goto Laf
            r1 = r3
            goto Lc5
        Laf:
            java.lang.String r0 = r3.getText()     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            char r0 = r0.charAt(r2)     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch: java.lang.IllegalArgumentException -> Lcf java.lang.NumberFormatException -> Ld1
            r6 = 6
            r7 = 0
            r1 = r3
            r3 = 0
            r5 = 0
            androidx.compose.ui.text.input.TextFieldValue r3 = androidx.compose.ui.text.input.TextFieldValue.m6391copy3r_uNRQ$default(r1, r2, r3, r5, r6, r7)     // Catch: java.lang.IllegalArgumentException -> Lc9 java.lang.NumberFormatException -> Lcb
        Lc5:
            r15.invoke(r3)     // Catch: java.lang.IllegalArgumentException -> Lc9 java.lang.NumberFormatException -> Lcb
            goto Ld3
        Lc9:
            r0 = move-exception
            goto Ld3
        Lcb:
            r0 = move-exception
            goto Ld3
        Lcd:
            r1 = r3
            goto Ld3
        Lcf:
            r0 = move-exception
            goto Ld2
        Ld1:
            r0 = move-exception
        Ld2:
            r1 = r3
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2750timeInputOnChangez7XvuPQ(int, androidx.compose.material3.TimePickerState, androidx.compose.ui.text.input.TextFieldValue, androidx.compose.ui.text.input.TextFieldValue, int, kotlin.jvm.functions.Function1):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x05bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0769  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0773  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0804  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0810  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x081b  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x082a  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0856  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0870  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x012b  */
    /* renamed from: TimePickerTextField-1vLObsk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m2739TimePickerTextField1vLObsk(final androidx.compose.ui.Modifier r112, final androidx.compose.ui.text.input.TextFieldValue r113, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r114, androidx.compose.material3.TimePickerState r115, int r116, androidx.compose.foundation.text.KeyboardOptions r117, androidx.compose.foundation.text.KeyboardActions r118, final androidx.compose.material3.TimePickerColors r119, androidx.compose.runtime.Composer r120, final int r121, final int r122) {
        /*
            Method dump skipped, instructions count: 2163
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TimePickerKt.m2739TimePickerTextField1vLObsk(androidx.compose.ui.Modifier, androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.material3.TimePickerState, int, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, androidx.compose.material3.TimePickerColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularLayout-uFdPcIQ, reason: not valid java name */
    public static final void m2737CircularLayoutuFdPcIQ(Modifier modifier, final float radius, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        MeasurePolicy value$iv;
        final Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(1548175696);
        ComposerKt.sourceInformation($composer2, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1871@72466L1666,1871@72419L1713:TimePicker.kt#uh7d8r");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(radius) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 147) == 146 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1548175696, $dirty2, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1870)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -328610546, "CC(remember):TimePicker.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 112) == 32;
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv || it$iv == Composer.INSTANCE.getEmpty()) {
                value$iv = new MeasurePolicy() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
                        return MeasurePolicy.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i3);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo34measure3p2s80s(MeasureScope $this$Layout, List<? extends Measurable> list, final long constraints) {
                        Object it$iv2;
                        Object it$iv3;
                        final float radiusPx = $this$Layout.mo367toPx0680j_4(radius);
                        long itemConstraints = Constraints.m6626copyZbe2FdA(constraints, (11 & 1) != 0 ? Constraints.m6638getMinWidthimpl(constraints) : 0, (11 & 2) != 0 ? Constraints.m6636getMaxWidthimpl(constraints) : 0, (11 & 4) != 0 ? Constraints.m6637getMinHeightimpl(constraints) : 0, (11 & 8) != 0 ? Constraints.m6635getMaxHeightimpl(constraints) : 0);
                        List target$iv = new ArrayList(list.size());
                        int size = list.size();
                        for (int index$iv$iv = 0; index$iv$iv < size; index$iv$iv++) {
                            Measurable measurable = list.get(index$iv$iv);
                            Measurable it = measurable;
                            if ((LayoutIdKt.getLayoutId(it) == LayoutId.Selector || LayoutIdKt.getLayoutId(it) == LayoutId.InnerCircle) ? false : true) {
                                target$iv.add(measurable);
                            }
                        }
                        List $this$fastMap$iv = target$iv;
                        List target$iv2 = new ArrayList($this$fastMap$iv.size());
                        int size2 = $this$fastMap$iv.size();
                        for (int index$iv$iv2 = 0; index$iv$iv2 < size2; index$iv$iv2++) {
                            Object item$iv$iv = $this$fastMap$iv.get(index$iv$iv2);
                            Measurable measurable2 = (Measurable) item$iv$iv;
                            target$iv2.add(measurable2.mo5535measureBRTryo0(itemConstraints));
                        }
                        final List placeables = target$iv2;
                        List $this$fastFirstOrNull$iv = list;
                        int index$iv$iv3 = 0;
                        int size3 = $this$fastFirstOrNull$iv.size();
                        while (true) {
                            if (index$iv$iv3 < size3) {
                                Object item$iv$iv2 = $this$fastFirstOrNull$iv.get(index$iv$iv3);
                                it$iv2 = item$iv$iv2;
                                Measurable it2 = (Measurable) it$iv2;
                                List $this$fastFirstOrNull$iv2 = $this$fastFirstOrNull$iv;
                                if (LayoutIdKt.getLayoutId(it2) == LayoutId.Selector) {
                                    break;
                                }
                                index$iv$iv3++;
                                $this$fastFirstOrNull$iv = $this$fastFirstOrNull$iv2;
                            } else {
                                it$iv2 = null;
                                break;
                            }
                        }
                        Measurable selectorMeasurable = (Measurable) it$iv2;
                        List $this$fastFirstOrNull$iv3 = list;
                        int index$iv$iv4 = 0;
                        int size4 = $this$fastFirstOrNull$iv3.size();
                        while (true) {
                            if (index$iv$iv4 < size4) {
                                Object item$iv$iv3 = $this$fastFirstOrNull$iv3.get(index$iv$iv4);
                                it$iv3 = item$iv$iv3;
                                Measurable it3 = (Measurable) it$iv3;
                                List $this$fastFirstOrNull$iv4 = $this$fastFirstOrNull$iv3;
                                if (LayoutIdKt.getLayoutId(it3) == LayoutId.InnerCircle) {
                                    break;
                                }
                                index$iv$iv4++;
                                $this$fastFirstOrNull$iv3 = $this$fastFirstOrNull$iv4;
                            } else {
                                it$iv3 = null;
                                break;
                            }
                        }
                        Measurable innerMeasurable = (Measurable) it$iv3;
                        final float theta = 6.2831855f / placeables.size();
                        final Placeable selectorPlaceable = selectorMeasurable != null ? selectorMeasurable.mo5535measureBRTryo0(itemConstraints) : null;
                        final Placeable innerCirclePlaceable = innerMeasurable != null ? innerMeasurable.mo5535measureBRTryo0(itemConstraints) : null;
                        return MeasureScope.CC.layout$default($this$Layout, Constraints.m6638getMinWidthimpl(constraints), Constraints.m6637getMinHeightimpl(constraints), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope $this$layout) {
                                Placeable placeable = selectorPlaceable;
                                if (placeable != null) {
                                    Placeable.PlacementScope.place$default($this$layout, placeable, 0, 0, 0.0f, 4, null);
                                }
                                List $this$fastForEachIndexed$iv = placeables;
                                long j = constraints;
                                float f = radiusPx;
                                float f2 = theta;
                                int index$iv = 0;
                                int size5 = $this$fastForEachIndexed$iv.size();
                                while (index$iv < size5) {
                                    Object item$iv = $this$fastForEachIndexed$iv.get(index$iv);
                                    Placeable it4 = (Placeable) item$iv;
                                    int i3 = index$iv;
                                    int centerOffsetX = (Constraints.m6636getMaxWidthimpl(j) / 2) - (it4.getWidth() / 2);
                                    int centerOffsetY = (Constraints.m6635getMaxHeightimpl(j) / 2) - (it4.getHeight() / 2);
                                    double d = f;
                                    List $this$fastForEachIndexed$iv2 = $this$fastForEachIndexed$iv;
                                    double offsetX = (Math.cos((i3 * f2) - 1.5707963267948966d) * d) + centerOffsetX;
                                    double offsetX2 = i3 * f2;
                                    double offsetY = centerOffsetY + (d * Math.sin(offsetX2 - 1.5707963267948966d));
                                    int centerOffsetX2 = MathKt.roundToInt(offsetX);
                                    int centerOffsetY2 = MathKt.roundToInt(offsetY);
                                    Placeable.PlacementScope.place$default($this$layout, it4, centerOffsetX2, centerOffsetY2, 0.0f, 4, null);
                                    index$iv++;
                                    $this$fastForEachIndexed$iv = $this$fastForEachIndexed$iv2;
                                    j = j;
                                }
                                Placeable placeable2 = innerCirclePlaceable;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.place$default($this$layout, placeable2, (Constraints.m6638getMinWidthimpl(constraints) - innerCirclePlaceable.getWidth()) / 2, (Constraints.m6637getMinHeightimpl(constraints) - innerCirclePlaceable.getHeight()) / 2, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv);
            } else {
                value$iv = it$iv;
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            int $changed$iv = (($dirty2 >> 6) & 14) | (($dirty2 << 3) & 112);
            ComposerKt.sourceInformationMarkerStart($composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int compositeKeyHash$iv = ComposablesKt.getCurrentCompositeKeyHash($composer2, 0);
            CompositionLocalMap localMap$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv = ComposedModifierKt.materializeModifier($composer2, modifier4);
            Function0 factory$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            int $changed$iv$iv = (($changed$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv);
            } else {
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv = Updater.m3678constructorimpl($composer2);
            Modifier modifier5 = modifier4;
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, localMap$iv, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2 block$iv$iv = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if ($this$Layout_u24lambda_u240$iv.getInserting() || !Intrinsics.areEqual($this$Layout_u24lambda_u240$iv.rememberedValue(), Integer.valueOf(compositeKeyHash$iv))) {
                $this$Layout_u24lambda_u240$iv.updateRememberedValue(Integer.valueOf(compositeKeyHash$iv));
                $this$Layout_u24lambda_u240$iv.apply(Integer.valueOf(compositeKeyHash$iv), block$iv$iv);
            }
            Updater.m3685setimpl($this$Layout_u24lambda_u240$iv, materialized$iv, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke($composer2, Integer.valueOf(($changed$iv$iv >> 6) & 14));
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = $composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TimePickerKt$CircularLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i3) {
                    TimePickerKt.m2737CircularLayoutuFdPcIQ(modifier3, radius, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
                }
            });
        }
    }

    /* renamed from: numberContentDescription-dSwYdS4, reason: not valid java name */
    public static final String m2748numberContentDescriptiondSwYdS4(int selection, boolean is24Hour, int number, Composer $composer, int $changed) {
        int id;
        ComposerKt.sourceInformationMarkerStart($composer, 194237364, "C(numberContentDescription)P(2:c#material3.TimePickerSelectionMode)1924@74567L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(194237364, $changed, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1914)");
        }
        if (TimePickerSelectionMode.m2765equalsimpl0(selection, TimePickerSelectionMode.INSTANCE.m2770getMinuteyecRtBI())) {
            Strings.Companion companion = Strings.INSTANCE;
            id = Strings.m2922constructorimpl(R.string.m3c_time_picker_minute_suffix);
        } else if (is24Hour) {
            Strings.Companion companion2 = Strings.INSTANCE;
            id = Strings.m2922constructorimpl(R.string.m3c_time_picker_hour_24h_suffix);
        } else {
            Strings.Companion companion3 = Strings.INSTANCE;
            id = Strings.m2922constructorimpl(R.string.m3c_time_picker_hour_suffix);
        }
        String strM2993getStringqBjtwXw = Strings_androidKt.m2993getStringqBjtwXw(id, new Object[]{Integer.valueOf(number)}, $composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return strM2993getStringqBjtwXw;
    }

    private static final float dist(float x1, float y1, int x2, int y2) {
        float x = x2 - x1;
        float y = y2 - y1;
        return (float) Math.hypot(x, y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float atan(float y, float x) {
        float ret = ((float) Math.atan2(y, x)) - 1.5707964f;
        return ret < 0.0f ? FullCircle + ret : ret;
    }

    static {
        MutableIntList $this$ExtraHours_u24lambda_u2446 = new MutableIntList(Hours.getSize());
        IntList this_$iv = Hours;
        int[] content$iv = this_$iv.content;
        int i = this_$iv._size;
        for (int i$iv = 0; i$iv < i; i$iv++) {
            int it = content$iv[i$iv];
            $this$ExtraHours_u24lambda_u2446.add((it % 12) + 12);
        }
        ExtraHours = $this$ExtraHours_u24lambda_u2446;
        PeriodToggleMargin = Dp.m6693constructorimpl(12);
    }

    private static final Modifier visible(Modifier $this$visible, final boolean visible) {
        return $this$visible.then(new VisibleModifier(visible, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TimePickerKt$visible$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                $this$null.setName("visible");
                $this$null.getProperties().set("visible", Boolean.valueOf(visible));
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}
