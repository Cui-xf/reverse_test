package com.cc.qbq;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();
    private static Function3<PaddingValues, Composer, Integer, Unit> lambda$1683739848 = ComposableLambdaKt.composableLambdaInstance(1683739848, false, new Function3() { // from class: com.cc.qbq.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MainActivityKt.lambda_1683739848$lambda$0((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-314245959, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f88lambda$314245959 = ComposableLambdaKt.composableLambdaInstance(-314245959, false, new Function2() { // from class: com.cc.qbq.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda__314245959$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-838732541, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f90lambda$838732541 = ComposableLambdaKt.composableLambdaInstance(-838732541, false, new Function2() { // from class: com.cc.qbq.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda__838732541$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$815840807 = ComposableLambdaKt.composableLambdaInstance(815840807, false, new Function2() { // from class: com.cc.qbq.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda_815840807$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-515286787, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f89lambda$515286787 = ComposableLambdaKt.composableLambdaInstance(-515286787, false, new Function3() { // from class: com.cc.qbq.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MainActivityKt.lambda__515286787$lambda$4((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: lambda$-23243594, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f87lambda$23243594 = ComposableLambdaKt.composableLambdaInstance(-23243594, false, new Function2() { // from class: com.cc.qbq.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda__23243594$lambda$5((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-23243594$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6991getLambda$23243594$app() {
        return f87lambda$23243594;
    }

    /* renamed from: getLambda$-314245959$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6992getLambda$314245959$app() {
        return f88lambda$314245959;
    }

    /* renamed from: getLambda$-515286787$app, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m6993getLambda$515286787$app() {
        return f89lambda$515286787;
    }

    /* renamed from: getLambda$-838732541$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m6994getLambda$838732541$app() {
        return f90lambda$838732541;
    }

    public final Function3<PaddingValues, Composer, Integer, Unit> getLambda$1683739848$app() {
        return lambda$1683739848;
    }

    public final Function2<Composer, Integer, Unit> getLambda$815840807$app() {
        return lambda$815840807;
    }

    static final Unit lambda__838732541$lambda$2(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C33@1333L250:MainActivity.kt#cfffgf");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-838732541, $changed, -1, "com.cc.qbq.ComposableSingletons$MainActivityKt.lambda$-838732541.<anonymous> (MainActivity.kt:33)");
            }
            MainActivityKt.QbqTheme(f88lambda$314245959, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__314245959$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C34@1360L209:MainActivity.kt#cfffgf");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-314245959, $changed, -1, "com.cc.qbq.ComposableSingletons$MainActivityKt.lambda$-314245959.<anonymous> (MainActivity.kt:34)");
            }
            ScaffoldKt.m2426ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, null, 0, 0L, 0L, null, lambda$1683739848, $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_1683739848$lambda$0(PaddingValues innerPadding, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "C35@1442L109:MainActivity.kt#cfffgf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        if (($dirty & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1683739848, $dirty, -1, "com.cc.qbq.ComposableSingletons$MainActivityKt.lambda$1683739848.<anonymous> (MainActivity.kt:35)");
            }
            MainActivityKt.PasswordCheckScreen(PaddingKt.padding(Modifier.INSTANCE, innerPadding), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda_815840807$lambda$3(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C65@2278L10:MainActivity.kt#cfffgf");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(815840807, $changed, -1, "com.cc.qbq.ComposableSingletons$MainActivityKt.lambda$815840807.<anonymous> (MainActivity.kt:65)");
            }
            TextKt.m2711Text4IGK_g("密码", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__515286787$lambda$4(RowScope Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C79@2668L10:MainActivity.kt#cfffgf");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-515286787, $changed, -1, "com.cc.qbq.ComposableSingletons$MainActivityKt.lambda$-515286787.<anonymous> (MainActivity.kt:79)");
            }
            TextKt.m2711Text4IGK_g("校验", (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda__23243594$lambda$5(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C92@2920L21:MainActivity.kt#cfffgf");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-23243594, $changed, -1, "com.cc.qbq.ComposableSingletons$MainActivityKt.lambda$-23243594.<anonymous> (MainActivity.kt:92)");
            }
            MainActivityKt.PasswordCheckScreen(null, $composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
